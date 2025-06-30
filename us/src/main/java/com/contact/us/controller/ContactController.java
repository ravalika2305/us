package com.contact.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.us.DTO.ContactRequestDTO;
import com.contact.us.exception.CustomException;
import com.contact.us.service.ContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/us")
public class ContactController {
	
	
	@Autowired
	public ContactService contactservice;
	
	@PostMapping("/submit")
	public ResponseEntity<String> submitContactForm(@Valid @RequestBody ContactRequestDTO contactrequestDTO){
		try {
			contactservice.submitForm(contactrequestDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body("Your query has been submitted succesfully. We Will respond shortly.");
		} catch (CustomException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
		}

}
}




