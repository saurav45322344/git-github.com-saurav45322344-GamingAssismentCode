package com.test.userlogin.controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.dropbox.core.v2.files.FileMetadata;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.WriteMode;

import jakarta.servlet.http.HttpServletResponse;

import com.dropbox.core.v2.DbxClientV2;


@RestController
@CrossOrigin
@RequestMapping("/maiora/dms")
public class DropBoxController {

	private DbxClientV2 dropboxClient;

	public DropBoxController(DbxClientV2 dropboxClient) {
		this.dropboxClient = dropboxClient;
	}

	@GetMapping("/dropbox/list")
	public List<String> listFiles() throws DbxException {
		List<String> fileNames = new ArrayList<>();
		ListFolderResult result = 
				dropboxClient.files().listFolder("");
		while (true) {
			for (Metadata metadata : result.getEntries()) {
				fileNames.add(metadata.getName());
			}
			if (!result.getHasMore()) {
				break;
			}
			result = 
					dropboxClient.files().listFolderContinue(result.getCursor());
		}
		return fileNames;
	}
	@PostMapping("/dropbox/upload")
	public void uploadFile(@RequestParam("file") MultipartFile file) 
			throws IOException, DbxException {
		String fileName = file.getOriginalFilename();
		try (InputStream in = file.getInputStream()) {
			FileMetadata metadata = 
					dropboxClient.files().uploadBuilder("/" + fileName)
					.withMode(WriteMode.OVERWRITE)
					.uploadAndFinish(in);
		}
	}
	@GetMapping("/dropbox/download")
	public void downloadFile(@RequestParam("filename") String fileName, 
			HttpServletResponse response) throws IOException, DbxException {
		FileMetadata metadata = 
				dropboxClient.files().downloadBuilder("/" + fileName)
				.download(response.getOutputStream());
	}


}
