package com.example.mapstruct.springmapstructdemo.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Data;


@Data
@Entity
@Table(name="product_dto")
public class ProductDto {
	
        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
        
        @NotBlank
        @Size(min=2, message = "Product name should have at least 2 characters ")
		private String name;
        
        @NotBlank
        @Size(min=5, max = 20, message = "Product description should have at least 5 characters and maximum of 20")
		private String description;
       
		private String quantity;
        
		private long price;
		
}


	


