package com.example.real_time_ad_serving_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RealTimeAdServingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeAdServingPlatformApplication.class, args);
	}

}
