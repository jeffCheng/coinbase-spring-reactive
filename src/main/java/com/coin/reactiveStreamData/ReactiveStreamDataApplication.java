package com.coin.reactiveStreamData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;

@SpringBootApplication(exclude = {MongoReactiveDataAutoConfiguration.class})
public class ReactiveStreamDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveStreamDataApplication.class, args);
	}

}
