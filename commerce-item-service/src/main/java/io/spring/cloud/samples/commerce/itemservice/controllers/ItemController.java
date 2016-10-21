package io.spring.cloud.samples.commerce.itemservice.controllers;

import io.spring.cloud.samples.commerce.itemservice.domain.Item;
import io.spring.cloud.samples.commerce.itemservice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	ItemRepository repository;

	@RequestMapping("/items")
	public Iterable<Item> items() {
		return repository.findAll();
	}

	@RequestMapping("/category/{cat}")
	public Iterable<Item> itemsByCategory(@PathVariable("cat") String category) {
		Iterable<Item> items = repository.findByCategory(category);
		return items;
	}

	@RequestMapping("/itemid/{id}")
	public Iterable<Item> itemById(@PathVariable("id") Long id) {
		Iterable<Item> items = repository.findById(id);
		return items;
	}
}
