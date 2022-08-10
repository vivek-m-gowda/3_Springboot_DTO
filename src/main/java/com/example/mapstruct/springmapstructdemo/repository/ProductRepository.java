package com.example.mapstruct.springmapstructdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mapstruct.springmapstructdemo.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
