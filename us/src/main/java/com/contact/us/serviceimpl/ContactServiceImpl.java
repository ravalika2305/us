package com.contact.us.serviceimpl;

import com.contact.us.DTO.ContactRequestDTO;
import com.contact.us.exception.CustomException;
import com.contact.us.model.ContactMessage;
import com.contact.us.repository.ContactMessageRepository;
import com.contact.us.service.ContactService;
import com.contact.us.EmailTemplateBuilder.EmailTemplateBuilder;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactMessageRepository repository;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private EmailTemplateBuilder emailTemplateBuilder;

    @Override
    public void submitForm(ContactRequestDTO dto) {
        log.info("submitForm method invoked with email: {}", dto.getEmail());

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new CustomException("Email already used. Please try another.");
        }

        if (repository.findByPhone(dto.getPhone()).isPresent()) {
            throw new CustomException("Phone number already used. Please try another.");
        }

        String cardColor = sanitizeCardColor(dto.getCardColor());

        ContactMessage message = new ContactMessage();
        message.setName(dto.getName());
        message.setPhone(dto.getPhone());
        message.setEmail(dto.getEmail());
        message.setMessage(dto.getMessage());
        message.setResponse("Thank you for contacting us. We will respond shortly.");
        message.setCardcolor(cardColor);

        repository.save(message);
        log.info("Contact form saved for: {}", dto.getEmail());

        sendAcknowledgementEmail(message.getEmail(), message.getName(), cardColor, message.getMessage());
    }

    private String sanitizeCardColor(String cardColor) {
        if (cardColor != null && cardColor.matches("^#[0-9a-fA-F]{6}$")) {
            return cardColor;
        }
        return "#08356C";  
    }

    private void sendAcknowledgementEmail(String email, String name, String cardColor, String messageText) {
        String htmlContent = emailTemplateBuilder.buildAcknowledgmentEmail(name, cardColor, messageText);

        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(email);
            helper.setSubject("Hi " + name + ", thanks for contacting SIVVG!");
            helper.setText(htmlContent, true);

            emailSender.send(mimeMessage);
            log.info("Acknowledgment email sent to: {}", email);
        } catch (Exception e) {
            log.error("Failed to send acknowledgment email to {}: {}", email, e.getMessage(), e);
            throw new CustomException("Failed to send acknowledgment email");
        }
    }
}
