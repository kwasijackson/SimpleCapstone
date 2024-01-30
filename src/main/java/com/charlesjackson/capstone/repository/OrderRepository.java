package com.charlesjackson.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charlesjackson.capstone.Entity.Orders;



@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
