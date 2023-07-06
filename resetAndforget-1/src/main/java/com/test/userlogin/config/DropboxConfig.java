package com.test.userlogin.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

@Configuration
public class DropboxConfig {

	
	@Value("${dropbox.app.key}")
	private String appKey; 
	
	@Value("${dropbox.app.secret}")
	 private String appSecret;
	
	 @Value("${dropbox.access.token}")
	 private String accessToken;
	 
	 @Bean
	 public DbxClientV2 dropboxClient() {
	 DbxRequestConfig config = 
	DbxRequestConfig.newBuilder("Photos_uploads").build();
	 return new DbxClientV2(config, 
			 "sl.BepexXRygJNRSJJQy2joK-6pfw4LRULgeDAxmHlkI7dEmSBFf-wmcB_w_3sGbMFPVEkEO_otEATSedsBrGb-u7Rj6h7LDODlOepBM303O5cPUz8w1cSiAueiaiDFbPUpxyEB9sw");
	 }
	
}
