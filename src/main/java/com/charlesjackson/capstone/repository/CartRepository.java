package com.charlesjackson.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlesjackson.capstone.Entity.Cart;
import com.charlesjackson.capstone.Entity.Login;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	List<Cart> findByLogin(Login login);

}