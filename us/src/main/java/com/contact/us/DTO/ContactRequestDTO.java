package com.contact.us.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ContactRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+91\\d{10}$", message = "Phone number must start with +91 and contain exactly 10 digits")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Message is required")
    private String message;


    private String cardColor = "royal blue";

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }


    public ContactRequestDTO() {
    }

    public ContactRequestDTO(String name, String phone, String email, String message, String cardColor) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.message = message;
        this.cardColor = cardColor != null ? cardColor : "royal blue"; // fallback to default
    }

    @Override
    public String toString() {
        return "ContactRequestDTO [name=" + name + ", phone=" + phone + ", email=" + email +
               ", message=" + message + ", cardColor=" + cardColor + "]";
    }
}

