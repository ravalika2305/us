package com.contact.us.EmailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.Contactus.EmailService.EmailService;
import com.contact.us.EmailTemplateBuilder.EmailTemplateBuilder;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailTemplateBuilder templateBuilder;

    @Override
    public void sendContactUsEmail(String toEmail, String name, String query, String cardColor) {
        String subject = "Thank You for Contacting SIVVG";
        String body = templateBuilder.buildContactUsEmail(name, query, 
                cardColor != null ? cardColor : "#4169e1");

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body, true); 
            helper.setFrom("your@email.com");
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
