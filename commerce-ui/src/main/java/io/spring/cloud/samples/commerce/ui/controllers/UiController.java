package io.spring.cloud.samples.commerce.ui.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.cloud.samples.commerce.ui.services.items.Item;
import io.spring.cloud.samples.commerce.ui.services.items.ItemService;
import io.spring.cloud.samples.commerce.ui.services.prices.PriceService;

/**
 * @author zhuangxie
 * @since 10/18/2016
 */
@RestController
public class UiController {

	@Autowired
	ItemService itemService;

	@Autowired
	PriceService priceService;

	@RequestMapping("/items")
	public Item[] itemsAll() {
		Item[] items = itemService.itemsAll();
		Map<String, String> prices = priceService.pricesAll();

		for (int i = 0; i < items.length; i++) {
			if (items[i].getId() == -1L) {
				items[i].setDescription("Item service not available.");
			} else if (prices.containsKey("itemId") && prices.get("itemId").equals("-1")) {
				items[i].setPrice("Price service not available.");
			} else if (prices.containsKey(items[i].getId().toString())) {
				items[i].setPrice(prices.get(items[i].getId().toString()));
			}
		}
		return items;
	}

	@RequestMapping("/category/{category}")
	public Item[] itemsByCategory(@PathVariable("category") String category) {
		Item[] items = itemService.itemsByCategory(category);
		Map<String, String> prices = priceService.pricesAll();

		for (int i = 0; i < items.length; i++) {
			if (items[i].getId() == -1L) {
				items[i].setDescription("Item service not available.");
			} else if (prices.containsKey("itemId") && prices.get("itemId").equals("-1")) {
				items[i].setPrice("Price service not available.");
			} else if (prices.containsKey(items[i].getId().toString())) {
				items[i].setPrice(prices.get(items[i].getId().toString()));
			}
		}
		return items;
	}

	@RequestMapping("/item/{itemId}")
	public Item[] itemsById(@PathVariable("itemId") String itemId) {
		Item[] items = itemService.itemsById(itemId);
		Map<String, String> prices = priceService.pricesById(itemId);

		if (items.length > 0) {
			if (items[0].getId() == -1L) {
				items[0].setDescription("Item service not available.");
			} else {
				if (prices.containsKey("itemId") && prices.get("itemId").equals("-1")) {
					items[0].setPrice("Price service not available.");
				} else if (prices.containsKey("itemId") && prices.get("itemId").equals(itemId)) {
					items[0].setPrice(prices.get("price"));
				}
			}
		}
		return items;
	}
}
