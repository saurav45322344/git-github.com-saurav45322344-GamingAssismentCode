package com.test.userlogin.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.userlogin.entity.TFolder;
import com.test.userlogin.service.TFolderService;

@RestController
@RequestMapping("/folders")
public class folderController {

	
	  private static final int OTP_LENGTH = 6;

	    @Autowired
	    private TFolderService folderService;

	    @Autowired
	    private JavaMailSender mailSender;

	    @PostMapping("/save")
	    public ResponseEntity<?> saveFolder(@RequestBody TFolder folder) throws Exception {
	        String otp = generateOTP();
	        sendOTP(folder.getfName(), otp); // send OTP to user via email
	        // save the folder with the OTP in the database
	        folder.setOtp(otp);
	        TFolder result = folderService.saveFolder(folder);
	        return ResponseEntity.ok(result);
	    }

	    private String generateOTP() {
	        // generate a random OTP of length OTP_LENGTH
	        Random rand = new Random();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < OTP_LENGTH; i++) {
	            sb.append(rand.nextInt(10));
	        }
	        return sb.toString();
	    }

	    private void sendOTP(String folderName, String otp) {
	        // send the OTP to the user via email
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo("ranjansaurav360@gmail.com");
	        message.setSubject("OTP for saving folder " + folderName);
	        message.setText("Your OTP is: " + otp);
	        mailSender.send(message);
	    }

	}

