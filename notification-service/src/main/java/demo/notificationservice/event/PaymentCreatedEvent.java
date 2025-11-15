package demo.notificationservice.event;

import java.time.Instant;
import java.util.UUID;

public record PaymentCreatedEvent(
        UUID paymentId,
        UUID customerId,
        Double amount,
        String status,
        Instant createdAt
) {
}
