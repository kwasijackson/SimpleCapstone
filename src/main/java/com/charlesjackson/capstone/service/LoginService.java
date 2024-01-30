package com.charlesjackson.capstone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.charlesjackson.capstone.Entity.Login;
import com.charlesjackson.capstone.repository.LoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;



@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ResponseEntity<String> signIn(Login login) {		
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		
		if(result.isPresent()) {
			Login ll = result.get();
			if(passwordEncoder.matches(login.getPassword(), ll.getPassword())) {
					
					if(ll.getTypeofuser().equals("admin")) {
						return new ResponseEntity<>("Admin Success",HttpStatus.OK);
					}else {
						return new ResponseEntity<>("Customer success",HttpStatus.OK);
					}
					
			}else {
				return new ResponseEntity<>("Password is wrong",HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>("EmailId is wrong",HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> signUp(Login login) {
		if(login.getTypeofuser().equals("admin")) {
			return new ResponseEntity<>("Sorry you can't create admin account",HttpStatus.BAD_REQUEST);
		}else {
			Optional<Login> result = loginRepository.findById(login.getEmailid());
			if(result.isPresent()) {
				return new ResponseEntity<>("Account alredy exists",HttpStatus.BAD_REQUEST);
			}else {
				
				login.setPassword(passwordEncoder.encode(login.getPassword()));;
				loginRepository.save(login);
				
				
				return new ResponseEntity<>("Account created successfully",HttpStatus.OK);
			}
		}
	}
public Login getById(String emailid) {

		return loginRepository.findById(emailid).orElse(null);
	
}

}
