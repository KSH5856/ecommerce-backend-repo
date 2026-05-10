package com.Ecommerce.EcommerceApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class ProductDetails {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "product_id")
	private long productId;
	private String title;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	private double price;
	private int stockCount;
	private String images;
}