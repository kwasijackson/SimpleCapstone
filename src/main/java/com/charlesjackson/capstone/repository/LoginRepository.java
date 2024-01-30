package com.charlesjackson.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.charlesjackson.capstone.Entity.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

}

