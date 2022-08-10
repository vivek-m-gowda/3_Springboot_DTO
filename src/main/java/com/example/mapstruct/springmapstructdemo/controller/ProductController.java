package com.example.mapstruct.springmapstructdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapstruct.springmapstructdemo.dto.ProductDto;
import com.example.mapstruct.springmapstructdemo.mapper.ProductMapper;
import com.example.mapstruct.springmapstructdemo.model.Product;
import com.example.mapstruct.springmapstructdemo.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductDto productDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(productDto));
	}
	
	@GetMapping("/get-byID/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductDtoById(id));
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<List<ProductDto>>getProductList(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductList());
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDto> saveProduct(@Valid @PathVariable Integer id, @RequestBody ProductDto productDto){
		Product product = productMapper.dtoToModel(productDto);
		productService.saveProduct(productDto);
		product.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDto);
		//return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		productService.deleteById(id);
		return ResponseEntity.ok("1 row deleted");
	}
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteById(@PathVariable(value="id")Integer id){
//	ProductDto productDto=productMapper.modelTODto(productRepository.findById(id).get());
//	productRepository.deleteById(productDto.getId());
//	 	//System.out.printf("1 row deleted \n");
//		return ResponseEntity.ok("1 row deleted");
//		
//	}
		
}

