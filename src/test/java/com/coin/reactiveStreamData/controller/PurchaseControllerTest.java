package com.coin.reactiveStreamData.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.coin.reactiveStreamData.model.Purchase;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PurchaseControllerTest {

	@Autowired
	ApplicationContext context;
	
	private WebTestClient webTestClient;
	
	@Before
	public void setUp() throws Exception {
		webTestClient =  WebTestClient.bindToApplicationContext(this.context).build();
	}

	@Test
	public void createPurchase() {
		webTestClient.get().uri("/coin/purchase/v1/{id}", 123)
		.exchange().expectStatus().isOk().expectBody(Purchase.class);
	}
}
