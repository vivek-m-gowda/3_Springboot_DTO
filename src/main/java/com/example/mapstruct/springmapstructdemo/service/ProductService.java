package com.example.mapstruct.springmapstructdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapstruct.springmapstructdemo.dto.ProductDto;
import com.example.mapstruct.springmapstructdemo.mapper.ProductMapper;
import com.example.mapstruct.springmapstructdemo.model.Product;
import com.example.mapstruct.springmapstructdemo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;
	//To save product
	public Product saveProduct(ProductDto productDto) {
		return productRepository.save(productMapper.dtoToModel(productDto));
	}
	//To List product by ID
	public ProductDto getProductDtoById(Integer id) {
		return productRepository.findById(id)
								.map(productMapper::modelTODto)
								.orElse(new ProductDto());
	}
	//To List All products
	public List<ProductDto> getProductList(){
		List<Product> products = productRepository.findAll();
		return productMapper.modelsTODtos(products);
	}
	
	//To delete
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}
	
}
