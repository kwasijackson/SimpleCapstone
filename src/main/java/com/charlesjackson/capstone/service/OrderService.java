package com.charlesjackson.capstone.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charlesjackson.capstone.Entity.Cart;
import com.charlesjackson.capstone.Entity.Login;
import com.charlesjackson.capstone.Entity.Orders;
import com.charlesjackson.capstone.repository.CartRepository;
import com.charlesjackson.capstone.repository.OrderDetailRepository;
import com.charlesjackson.capstone.repository.OrderRepository;
import com.charlesjackson.capstone.Entity.OrderDetails;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired 
	OrderDetailService orderDetailService;
	@Autowired 
	LoginService loginService;
	@Autowired
	CartRepository cartRepository;
	@Autowired OrderDetailRepository orderDetailRepository;
	

	public ResponseEntity<String> placeOrder(Orders orders) {
		Login login = orders.getLogin();
		for(Cart item: cartRepository.findByLogin(login)){
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrders(orders);
			orderDetails.setQuantity(item.getQuantity());
			orderDetails.setProduct(item.getProduct());
			orderDetails.setOrderplaced(LocalDate.now());
			orderDetails.setPrice(item.getProduct().getPrice());
			orderDetailRepository.save(orderDetails);
			cartRepository.deleteById(item.getCartId());
			

		}
		
		orderRepository.save(orders);
		return new ResponseEntity<> ("order placed Successfully",HttpStatus.CREATED);
	}

}
