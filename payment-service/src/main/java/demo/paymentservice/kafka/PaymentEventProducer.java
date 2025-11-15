package demo.paymentservice.kafka;

import demo.paymentservice.event.PaymentCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentEventProducer {

    private final StreamBridge bridge;

    public PaymentEventProducer(StreamBridge bridge) {
        this.bridge = bridge;
    }

    public void sendPaymentEvent(PaymentCreatedEvent event){
        boolean sent=bridge.send("paymentEvents-out-0",event);  //application.yml de tanımladığımız binding

        if (sent){
            log.info("Payment event published",event);
        }
        else {
            log.error("Failed event",event);
        }
    }

}
