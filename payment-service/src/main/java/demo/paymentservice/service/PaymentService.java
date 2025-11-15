package demo.paymentservice.service;

import demo.paymentservice.event.PaymentCreatedEvent;
import demo.paymentservice.kafka.PaymentEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
public class PaymentService {
    private final PaymentEventProducer eventProducer;

    public PaymentService(PaymentEventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    public PaymentCreatedEvent processPayment(UUID customerId, Double amount) {

        //ödeme sisteminin simüle ediyoruz
        double random = Math.random();   //0 ile 1 arası sayı

        boolean success = random > 0.5; //eğer random 0.5 ten büyük gelirse başarılı

        String status;

        if (success) {
            status = "SUCCESS";          // Ödeme başarılı
        } else {
            status = "FAIL";             // Ödeme başarısız
        }

        //bu JSON a dönüşüp Kafkaya gidecek olan veri
        PaymentCreatedEvent event=new PaymentCreatedEvent(
                UUID.randomUUID(),   // paymentId
                customerId,
                amount,
                status,
                Instant.now()
        );
        log.info("Payment process", status);


        eventProducer.sendPaymentEvent(event);

        return event;
    }
}
