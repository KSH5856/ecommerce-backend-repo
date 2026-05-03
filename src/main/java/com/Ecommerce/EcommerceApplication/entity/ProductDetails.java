package com.Ecommerce.EcommerceApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class 	ProductDetails {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String title;
	private String description;
	private String category;
	private double price;
	private int stock;
	private String images;
}