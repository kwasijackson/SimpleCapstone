package com.charlesjackson.capstone.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.charlesjackson.capstone.Entity.Category;


public interface CategoryReposity extends JpaRepository<Category,Integer> {

}


