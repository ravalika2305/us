package com.contact.us.EmailTemplateBuilder;

import org.springframework.stereotype.Component;

@Component
public class EmailTemplateBuilder {

    public String buildAcknowledgmentEmail(String name, String cardColor, String messageText) {
        if (cardColor == null || !cardColor.matches("^#[0-9a-fA-F]{6}$")) {
            cardColor = "#08356C";
        }

        return "<!DOCTYPE html>"
            + "<html><head><meta charset='UTF-8'></head><body>"
            + "<div style='max-width:600px;margin:20px auto;padding:20px;"
            + "border-radius:10px;background-color:" + cardColor + ";color:white;"
            + "font-family:Arial,sans-serif;box-shadow:0 4px 8px rgba(0,0,0,0.2);'>"
            
            + "<h2 style='margin-top:0;'>Thank You for Contacting Us</h2>"
            + "<p>Hi <strong>" + name + "</strong>,</p>"
            + "<p>We appreciate your interest in <strong>SIVVG</strong>. Your message is important to us and has been received successfully.</p>"
            
            + "<div style='margin:20px 0;padding:15px;border-radius:5px;background:white;color:black;'>"
            + "<strong>Your Message:</strong><br/>" + messageText + "</div>"
            
            + "<p>At <strong>SIVVG</strong>, we are dedicated to delivering top-notch trading solutions that empower investors with real-time insights and actionable intraday tips.</p>"
            + "<p>You will receive a response shortly. Stay connected with <strong>SIVVG</strong>.</p>"
            + "<p>Best regards,<br/><strong>The SIVVG Team</strong></p>"
            + "</div></body></html>";
    }

    public String buildContactUsEmail(String name, String query, String cardColor) {
        if (cardColor == null || !cardColor.matches("^#[0-9a-fA-F]{6}$")) {
            cardColor = "#08356C";
        }

        return "<!DOCTYPE html>"
            + "<html><head><meta charset='UTF-8'></head><body>"
            + "<div style='max-width:600px;margin:20px auto;padding:20px;"
            + "border-radius:10px;background-color:" + cardColor + ";color:white;"
            + "font-family:Arial,sans-serif;box-shadow:0 4px 8px rgba(0,0,0,0.2);'>"
            
            + "<h2 style='margin-top:0;'>New Contact Us Query from " + name + "</h2>"
            
            + "<div style='margin:20px 0;padding:15px;border-radius:5px;background:white;color:black;'>"
            + "<strong>Query:</strong><br/>" + query + "</div>"
            
            + "<p>Regards,<br/><strong>SIVVG Website</strong></p>"
            + "</div></body></html>";
    }
}
