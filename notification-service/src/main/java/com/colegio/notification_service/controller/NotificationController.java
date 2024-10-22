package com.colegio.notification_service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.notification_service.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/payment")
    public ResponseEntity<String> sendPaymentNotification(@RequestBody Map<String, String> request) {
        notificationService.sendPaymentNotification(
            request.get("to"),
            request.get("subject"),
            request.get("body")
        );
        return ResponseEntity.ok("Notificación enviada");
    }
}

