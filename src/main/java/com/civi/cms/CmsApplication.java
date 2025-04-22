package com.civi.cms;

import com.civi.cms.config.DatabaseUrlConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CmsApplication {

	public static void main(String[] args)
	{
		//DatabaseUrlConverter.getJdbcUrl();
		SpringApplication.run(CmsApplication.class, args);


	}

}
