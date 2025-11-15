package demo.paymentservice.controller;

import demo.paymentservice.event.PaymentCreatedEvent;
import demo.paymentservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentCreatedEvent create(@RequestParam UUID customerId,
                                      @RequestParam Double amount){
        return service.processPayment(customerId,amount);
    }
}
