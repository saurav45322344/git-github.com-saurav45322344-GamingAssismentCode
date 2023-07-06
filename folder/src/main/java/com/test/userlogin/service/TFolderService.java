package com.test.userlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.userlogin.entity.TFolder;
import com.test.userlogin.repository.TFolderRepository;


@Service
public class TFolderService {

	
	@Autowired
	private TFolderRepository folderRepository;
	
	   public TFolder saveFolder(TFolder folder) throws Exception {
	        String otp = folder.getOtp();
	        if (otp == null || otp.isEmpty()) {
	            throw new Exception("OTP is required");
	        }
	        TFolder existingFolder = folderRepository.findByfName(folder.getfName());
	        if (existingFolder != null && !existingFolder.getOtp().equals(otp)) {
	            throw new Exception("Invalid OTP");
	        }
	        return folderRepository.save(folder);
	    }
	}
	

