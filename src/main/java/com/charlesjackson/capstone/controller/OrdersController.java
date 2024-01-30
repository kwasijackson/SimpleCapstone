package com.charlesjackson.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesjackson.capstone.Entity.Cart;
import com.charlesjackson.capstone.Entity.Orders;
import com.charlesjackson.capstone.service.LoginService;
import com.charlesjackson.capstone.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Orders")
public class OrdersController {
	@Autowired
	OrderService orderService;
	@Autowired
	LoginService loginService;
	
	@PostMapping(value = "placeOrder")
public ResponseEntity<String> placeOrder(@RequestBody Orders orders) {
		
		return orderService.placeOrder(orders);
		
	}

}
