package io.spring.cloud.samples.commerce.itemservice.repositories;

import io.spring.cloud.samples.commerce.itemservice.domain.Item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item, String> {

	@Query("select item from Item item where item.category = ?1")
    Iterable<Item> findByCategory(String category);
}
