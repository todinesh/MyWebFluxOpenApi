package com.dishatech.openapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.dishatech.openapi.api.CustomerApi;
import com.dishatech.openapi.api.CustomerApiDelegate;
import com.dishatech.openapi.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerApiImpl implements CustomerApiDelegate {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Mono<ResponseEntity<Void>> createCustomer(@Valid Mono<com.dishatech.openapi.model.Customer> customer,
			ServerWebExchange exchange) {
		logger.info("createCustomer...");
        return Mono.just(ResponseEntity.accepted().build());
	}

	@Override
	public Mono<ResponseEntity<Flux<com.dishatech.openapi.model.Customer>>> getAllCustomers(
			ServerWebExchange exchange) {
		
		logger.info("getAllCustomers...");
    	
    	List<Customer> custList = new ArrayList<Customer>();
		Customer cust1 = new Customer();
		cust1.setFirstName("John");
		cust1.setLastName("Doe");

		Customer cust2 = new Customer();
		cust2.setFirstName("Jane");
		cust2.setLastName("Doe");
		
		custList.add(cust1);
		custList.add(cust2);
		
        Flux<com.dishatech.openapi.model.Customer> fluxCust = Flux.fromIterable(custList);
		
        return Mono.just(ResponseEntity.ok(fluxCust));
	}

	@Override
	public Mono<ResponseEntity<Object>> getByLastName(String lastName, ServerWebExchange exchange) {
		logger.info("getByLastName...{}", lastName);
		
		Customer cust = new Customer();
		cust.setFirstName("John");
		cust.setLastName("Doe");
		
        return Mono.just(ResponseEntity.ok(cust));
	}

	@Override
	public Mono<ResponseEntity<Object>> updateCustomer(String lastName,
			@Valid Mono<com.dishatech.openapi.model.Customer> customer, ServerWebExchange exchange) {
		logger.info("updateCustomer... {}", lastName);
		Customer cust = new Customer();
		cust.setFirstName("John");
		cust.setLastName("Doe");
		
        return Mono.just(ResponseEntity.ok(cust));
	}
	
}
