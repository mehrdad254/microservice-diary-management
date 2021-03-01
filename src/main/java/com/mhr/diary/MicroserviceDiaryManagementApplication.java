package com.mhr.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceDiaryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDiaryManagementApplication.class, args);
	}

}
