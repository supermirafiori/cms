package com.civi.cms;

import com.civi.cms.config.DatabaseUrlConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class
CmsApplication {

	public static void main(String[] args)
	{
		DatabaseUrlConverter.getJdbcUrl();
		SpringApplication.run(CmsApplication.class, args);


	}

}
