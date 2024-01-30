package com.charlesjackson.capstone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesjackson.capstone.Entity.Category;
import com.charlesjackson.capstone.Entity.Product;
import com.charlesjackson.capstone.service.ProductService;



@RestController
@RequestMapping("Product")
@CrossOrigin
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	@GetMapping("allProduct")
	public ResponseEntity<List<Product>> getAllProducts() {
		
		 return  productService.getAll();
		 
	}
	@PostMapping(value="add" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		
		return productService.addproduct(product);
	}
	
	@GetMapping("{Id}")
	public Optional<Product> getProductById(@PathVariable Integer Id) {
		
		return  productService.getProductsById(Id);
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable Category category) {
		
		return  productService.getProductByCategory(category);
	}
	
	@DeleteMapping("delete/{Id}")
	   public String deleteCategoryById(@PathVariable Integer Id) {
		   return productService.deleteCategoryById(Id);
	   }
	
}
