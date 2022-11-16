package com.techgeeknext.service;

import com.techgeeknext.request.NotificationEmail;
import org.springframework.web.multipart.MultipartFile;

public interface NotificationService {
    boolean sendTextNotificationEmail(NotificationEmail notificationEmail);
    boolean sendNotificationEmailWithAttachment(NotificationEmail notificationEmail,
                                             MultipartFile file);
}
