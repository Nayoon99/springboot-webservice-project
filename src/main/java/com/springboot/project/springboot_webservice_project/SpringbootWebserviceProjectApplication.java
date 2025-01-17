package com.springboot.project.springboot_webservice_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //JPA Auditing 활성화
@SpringBootApplication
public class SpringbootWebserviceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebserviceProjectApplication.class, args);
	}

}
