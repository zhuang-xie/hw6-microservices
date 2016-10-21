package io.spring.cloud.samples.commerce.ui.services.items;

/**
 * @author zhuangxie
 * @since 10/18/2016
 */
public class Item {
	private Long id;
	private String name;
	private String description;
	private String category;
	private String price;

	public Item() {
	}

	public Item(Long id, String name, String description, String category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = "n/a";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
