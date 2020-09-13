package com.borislavmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAspectJAutoProxy
public class WebCustomerTrackerApplication {

	public static void main(String[] args) {
			SpringApplication.run(WebCustomerTrackerApplication.class, args);
	}

}
