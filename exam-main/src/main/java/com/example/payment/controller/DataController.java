package com.example.payment.controller;

import com.example.payment.repository.Card;
import com.example.payment.repository.CardRepository;
import com.example.payment.repository.Product;
import com.example.payment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data")
public class DataController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CardRepository cardRepository;

	@PostMapping(value = "/addAll")
	public String addAllProduct() {

		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		product1.setName("TV");
		product2.setName("Iphone");
		product3.setName("Washing Machine");

		product1.setPrice(10000);
		product2.setPrice(12000);
		product3.setPrice(2000);

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);

		Card card1 = new Card();
		Card card2 = new Card();
		Card card3 = new Card();
		card1.setName("Gold");
		card2.setName("Silver");
		card3.setName("Normal");

		card1.setPercentage(20);
		card2.setPercentage(10);
		card3.setPercentage(0);
		cardRepository.save(card1);
		cardRepository.save(card2);
		cardRepository.save(card3);
		return "added dummy data";
	}

}
