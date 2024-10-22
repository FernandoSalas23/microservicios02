package com.colegio.notification_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = "paymentNotificationQueue")
    public void receivePaymentNotification(String message) {
        System.out.println("Notificación de pago recibida: " + message);
        
        try {
            notificationService.sendPaymentNotification("andrewajax931@gmail.com", "Nuevo Pago Recibido", message);
        } catch (Exception e) {
            System.err.println("Error al enviar la notificación: " + e.getMessage());
        }
    }
}
