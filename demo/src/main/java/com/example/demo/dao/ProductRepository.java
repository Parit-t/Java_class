package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
