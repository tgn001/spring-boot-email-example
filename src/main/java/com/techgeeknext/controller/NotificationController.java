package com.techgeeknext.controller;

import com.techgeeknext.request.NotificationEmail;
import com.techgeeknext.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("/sendNotificationEmail")
    public ResponseEntity<String> sendNotificationEmail(@ModelAttribute NotificationEmail notificationEmail) {
        boolean emailSent = false;
        if (notificationEmail.getFile()!=null) {
            emailSent = notificationService.sendNotificationEmailWithAttachment(notificationEmail, notificationEmail.getFile());
        } else {
            emailSent = notificationService.sendTextNotificationEmail(notificationEmail);
        }
        if (emailSent) {
            return ResponseEntity.ok("Email sent.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while sending email.");
        }
    }
}
