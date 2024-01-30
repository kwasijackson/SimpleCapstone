package com.charlesjackson.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charlesjackson.capstone.Entity.Category;
import com.charlesjackson.capstone.Entity.Product;
import com.charlesjackson.capstone.repository.ProductRepository;
@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	public ResponseEntity<String> addproduct(Product product) {
		productRepository.save(product);
		 
		 return   new ResponseEntity<> ("successful",HttpStatus.CREATED);
	}

	public ResponseEntity<List<Product>> getAll() {
		try {
			return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		  }
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	public Optional<Product> getProductsById(int id) {
		
		return productRepository.findById(id);
	}

public ResponseEntity<List<Product>> getProductByCategory(Category category) {
		try {
			return new ResponseEntity<>(productRepository.findByCategory(category),HttpStatus.OK);
			}catch (Exception e){
			e.printStackTrace();
			}
			return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

public String deleteCategoryById(Integer id) {
	productRepository.deleteById(id);
	return "Record deleted Successfully";
}

}
