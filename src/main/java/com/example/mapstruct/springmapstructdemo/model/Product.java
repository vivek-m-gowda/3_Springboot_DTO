package com.example.mapstruct.springmapstructdemo.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private int quantity;
	private long price;
	
	
	
	
}
