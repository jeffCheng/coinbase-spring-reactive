package com.coin.reactiveStreamData.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coin.reactiveStreamData.model.Purchase;
import com.coin.reactiveStreamData.service.CoinbaseService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/purchase/v1")
public class PurchaseController {
	
	@Autowired
	CoinbaseService coinbaseService;
	
	@PostMapping(value = "/{name}")
	public Mono<Purchase> createPurchase(@PathVariable("name") String name){
		return coinbaseService.createPurchase(name);
	}

}
