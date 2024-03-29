package com.coin.reactiveStreamData.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.coin.reactiveStreamData.model.CoinBaseResponse;
import com.coin.reactiveStreamData.model.Purchase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CoinbaseServiceImpl implements CoinbaseService {

	@Autowired
	private WebClient webClient;

	@Autowired
	private ReactiveMongoOperations reactiveMongoTemplate;

	@Override
	public Mono<CoinBaseResponse> getCryptoPrice(String priceName) {
		return webClient.get().uri("https://api.coinbase.com/v2/prices/{crypto}/buy", priceName).exchange()
				.flatMap(clientResponse -> clientResponse.bodyToMono(CoinBaseResponse.class));
	}

	@Override
	public Mono<Purchase> createPurchase(String priceName) {
		return getCryptoPrice(priceName).flatMap(price -> reactiveMongoTemplate
				.save(new Purchase(priceName, price.getData().getAmount(), LocalDateTime.now())));
	}

	@Override
	public Mono<Purchase> getPurchaseById(String id) {
		return reactiveMongoTemplate.findById(id, Purchase.class);
	}

	@Override
	public Flux<Purchase> listAllPurchase() {
		return reactiveMongoTemplate.findAll(Purchase.class);
	}

}
