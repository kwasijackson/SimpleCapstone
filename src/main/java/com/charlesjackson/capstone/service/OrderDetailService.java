package com.charlesjackson.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charlesjackson.capstone.Entity.OrderDetails;
import com.charlesjackson.capstone.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
 @Autowired 
 OrderDetailRepository orderDetailRepository;
	public ResponseEntity<String> addOrderDetail(OrderDetails orderDetail) {
		orderDetailRepository.save(orderDetail);
		return new ResponseEntity<> ("order placed Successfully",HttpStatus.CREATED);
	}

}
