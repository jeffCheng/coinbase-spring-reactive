package com.coin.reactiveStreamData.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@Configuration
public class ApiConfig {
	
	@Bean
	public ObjectMapper objectMapper(){
		ObjectMapper objecMpapper = new ObjectMapper();
		return objecMpapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	@Bean
	public ObjectWriter objectWriter(ObjectMapper objecMpapper){
		return objecMpapper.writerWithDefaultPrettyPrinter();
	}
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().clientConnector(new ReactorClientHttpConnector()).build();
	}

}
