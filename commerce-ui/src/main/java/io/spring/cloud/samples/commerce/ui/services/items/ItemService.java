package io.spring.cloud.samples.commerce.ui.services.items;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhuangxie
 * @since 10/18/2016
 */
@Service
public class ItemService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackItemsAll")
	public Item[] itemsAll() {
		return restTemplate.getForObject("http://item/items", Item[].class);
	}

	@HystrixCommand(fallbackMethod = "fallbackItemsByCategory")
	public Item[] itemsByCategory(String category) {
		return restTemplate.getForObject("http://item/category/" + category, Item[].class);
	}

	@HystrixCommand(fallbackMethod = "fallbackItemsById")
	public Item[] itemsById(String id) {
		return restTemplate.getForObject("http://item/itemid/" + id, Item[].class);
	}

	private Item[] fallbackItemsAll() {
		return new Item[] { new Item(-1L, "n/a", "n/a", "n/a") };
	}

	private Item[] fallbackItemsByCategory(String category) {
		return new Item[] { new Item(-1L, "n/a", "n/a", "n/a") };
	}

	private Item[] fallbackItemsById(String id) {
		return new Item[] { new Item(-1L, "n/a", "n/a", "n/a") };
	}
}
