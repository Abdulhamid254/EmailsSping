package io.abdul.userserviceemails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class UserserviceemailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceemailsApplication.class, args);
	}

}
