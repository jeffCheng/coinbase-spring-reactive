package com.coin.reactiveStreamData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coin.reactiveStreamData.model.CoinBaseResponse;
import com.coin.reactiveStreamData.service.CoinbaseService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/price/v1")
public class PriceController {
	
	@Autowired
	CoinbaseService coinbaseService;
	
	@GetMapping(value = "/{name}")
	// TODO change String to Domain Model type when it's ready.
	public Mono<CoinBaseResponse> getPrice(@PathVariable String name){
		
		//TODO Use autowired service bean to get price
		return coinbaseService.getCryptoPrice(name);
	}
	

}
