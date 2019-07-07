package com.coin.reactiveStreamData.service;

import com.coin.reactiveStreamData.model.CoinBaseResponse;
import com.coin.reactiveStreamData.model.Purchase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoinbaseService {
	
	Mono<CoinBaseResponse> getCryptoPrice(String priceName);
	Mono<Purchase> createPurchase(String priceName);
	Mono<Purchase> getPurchaseById(String id);
	Flux<Purchase> listAllPurchase();
}
