package com.coin.reactiveStreamData.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.coin.reactiveStreamData.model.Purchase;
import com.coin.reactiveStreamData.service.CoinbaseService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PurchaseHandler {
	
	
	@Autowired
	CoinbaseService coinbaseService;

	public Mono<ServerResponse> listPurchase(ServerRequest serverRequest ) {
		final Mono<Purchase> purchase = coinbaseService.getPurchaseById(serverRequest.pathVariable("id"));
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(purchase,Purchase.class );
	
	}
	
	
	public Mono<ServerResponse> listAllPurchases(ServerRequest serverRequest){
		final Flux<Purchase> purchaseFlux = coinbaseService.listAllPurchase();

		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(purchaseFlux.collectList(),new ParameterizedTypeReference<List<Purchase>>()
						{
					});
						}
	
}
