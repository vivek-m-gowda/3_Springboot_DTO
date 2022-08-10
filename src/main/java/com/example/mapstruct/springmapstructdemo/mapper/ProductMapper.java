package com.example.mapstruct.springmapstructdemo.mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;

import com.example.mapstruct.springmapstructdemo.dto.ProductDto;
import com.example.mapstruct.springmapstructdemo.model.Product;

@Mapper(componentModel="spring",imports=UUID.class)
public interface ProductMapper {
	
	//To save product [convert productDto to product]
	Product dtoToModel(ProductDto productDto);	
	//To list product by ID [convert product to productDto]
	ProductDto modelTODto(Product product);
	//To list all products [convert product to productDto]
	List<ProductDto> modelsTODtos(List<Product> product);	

}