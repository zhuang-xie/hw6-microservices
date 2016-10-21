package io.spring.cloud.samples.commerce.ui.services.prices;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhuangxie
 * @since 10/18/2016
 */
@Service
public class PriceService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackPrices")
	public Map<String, String> pricesAll() {
		return restTemplate.getForObject("http://price/prices", Map.class);
	}

	@HystrixCommand(fallbackMethod = "fallbackPrices")
	public Map<String, String> pricesById(String id) {
		return restTemplate.getForObject("http://price/itemid/" + id, Map.class);
	}

	private Map<String, String> fallbackPrices() {
		return getFallbackPrice();
	}

	private Map<String, String> fallbackPrices(String id) {
		return getFallbackPrice();
	}

	private Map<String, String> getFallbackPrice() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("itemId", "-1");
		result.put("price", "n/a");
		return result;
	}
}
