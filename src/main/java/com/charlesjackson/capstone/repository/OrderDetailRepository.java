package com.charlesjackson.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.charlesjackson.capstone.Entity.OrderDetails;



public interface OrderDetailRepository  extends JpaRepository<OrderDetails, Integer>{

}
