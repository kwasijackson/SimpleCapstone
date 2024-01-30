package com.charlesjackson.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlesjackson.capstone.Entity.OrderDetails;
import com.charlesjackson.capstone.service.OrderDetailService;

@RestController
@RequestMapping("OrderDetail")
@CrossOrigin
public class OrderDetailController {
	@Autowired
	OrderDetailService orderDetailService;
	

	@PostMapping(value = "addOrderDetail")
	public ResponseEntity<String> toCart(@RequestBody OrderDetails orderDetail) {
		
		return orderDetailService.addOrderDetail(orderDetail);
		
	}
	
	@GetMapping(value = "getOrderDetail")
	public ResponseEntity<String> getAllOrderDetail(@RequestBody OrderDetails orderDetail) {
		
		return orderDetailService.addOrderDetail(orderDetail);
		
	}
}
