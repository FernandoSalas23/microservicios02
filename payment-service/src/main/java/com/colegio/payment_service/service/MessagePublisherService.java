package com.colegio.payment_service.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisherService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendPaymentNotification(String message) {
        rabbitTemplate.convertAndSend("paymentNotificationQueue", message);
    }
}
