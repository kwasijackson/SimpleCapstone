package com.charlesjackson.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charlesjackson.capstone.Entity.Category;
import com.charlesjackson.capstone.repository.CategoryReposity;
@Service
public class CategoryService {
 @Autowired
 CategoryReposity categoryRepositoy;
	public ResponseEntity<String> addCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<List<Category>> getAllCategory() {
		
		return new ResponseEntity<>( categoryRepositoy.findAll(),HttpStatus.OK);
	}

	public Optional<Category> getCategoryById(Integer id) {
		
		return categoryRepositoy.findById(id);
	}

	public String deleteCategoryById(Integer id) {
		Category category = categoryRepositoy.findById(id).orElse(null);
		if(category !=null) {
		categoryRepositoy.deleteById(id);
		return "Category Deleted Successfully";
		}
		return null;
	
	}

}
