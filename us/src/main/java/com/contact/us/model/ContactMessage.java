package com.contact.us.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_messages")
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @Column(unique = true)
    public String phone;

    @Column(unique = true)
    public String email;

    public String message;

    public String response;

    public String cardcolor;  // Fixed: changed from boolean to String

    public ContactMessage() {
        super();
    }

    public ContactMessage(Long id, String name, String phone, String email, String message, String response,
                          String cardcolor) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.message = message;
        this.response = response;
        this.cardcolor = cardcolor;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCardcolor() {
        return cardcolor;
    }

    public void setCardcolor(String cardcolor) {
        this.cardcolor = cardcolor;
    }

    @Override
    public String toString() {
        return "ContactMessage [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", message="
                + message + ", response=" + response + ", cardcolor=" + cardcolor + "]";
    }
}
