package com.charlesjackson.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlesjackson.capstone.Entity.Category;
import com.charlesjackson.capstone.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	//List<Product> findProductByCategory(String category);
	List<Product> findByCategory(Category category);
}
