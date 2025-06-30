package com.contact.us.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.us.model.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long>{
	
	Optional<ContactMessage> findByEmail(String email);
	
	Optional<ContactMessage> findByPhone(String phone);
}
