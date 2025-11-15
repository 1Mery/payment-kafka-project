package demo.notificationservice.kafka;

import demo.notificationservice.event.PaymentCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class PaymentEventListener {

    private static final Logger log =
            LoggerFactory.getLogger(PaymentEventListener.class);

    @Bean
    public Consumer<PaymentCreatedEvent> paymentEvents() {
        return event -> {

            // gelen mesajı ekrana yaz
            log.info("Payments event received: {}", event);

            // mesaj başarıysa mail gönder
            if ("SUCCESS".equals(event.status())) {
                log.info("Sent mail to customer {}", event.customerId());
            }
            // mesaj başarısızsa uyarı gönder
            else {
                log.warn("Payment FAILED for customer {}", event.customerId());
            }
        };
    }
}
