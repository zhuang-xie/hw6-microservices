package io.spring.cloud.samples.commerce.priceservice.controllers;

import io.spring.cloud.samples.commerce.priceservice.repositories.PriceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableConfigurationProperties(PriceConfig.class)
public class PriceController {
	
  @Autowired
  PriceConfig priceConfig;

  @RequestMapping("/prices")
  public Map<String,String> prices() {
    return priceConfig.getPrices();
  }

  @RequestMapping("/itemid/{itemId}")
  public Map<String,String> priceForItem(@PathVariable("itemId") String itemdId) {
    String price = priceConfig.getPriceForItem(itemdId);
    Map<String,String> result = new HashMap<>();
    if(price != null) {
      result.put("itemId", itemdId);
      result.put("price", price);
    }
    return result;
  }
}
