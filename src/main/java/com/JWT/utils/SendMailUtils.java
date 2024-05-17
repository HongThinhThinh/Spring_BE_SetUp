package com.JWT.utils;

import com.JWT.model.entity.User;
import com.JWT.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMailUtils {
    @Autowired
    EmailService emailService;

    public void threadSendMail(User user, String subject, String description) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                emailService.sendMail(user, subject, description);
            }

        };
        new Thread(r).start();
    }
}
