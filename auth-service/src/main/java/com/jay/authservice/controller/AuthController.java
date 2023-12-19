package com.jay.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.authservice.entity.LoginDetails;
import com.jay.authservice.entity.SuccessResponse;
import com.jay.authservice.exception.LoginException;
import com.jay.authservice.jwt.JWTGenerator;
import com.jay.authservice.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService authService;
	private JWTGenerator jwtGenerator;
	private AuthenticationManager authenticationManager;

	public AuthController(AuthenticationManager authenticationManager, JWTGenerator jwtGenerator, AuthService authService) {
		this.authService = authService;
		this.authenticationManager = authenticationManager;
		this.jwtGenerator = jwtGenerator;
	}

	@GetMapping("/login")
	public ResponseEntity<SuccessResponse> login(@RequestBody LoginDetails loginDetails) throws LoginException {
		UserDetails userDetails;
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDetails.getUsername(), loginDetails.getPassword()));
		} catch (UsernameNotFoundException exception) {
			throw new LoginException("Enter correct username or password");
		}
		userDetails = authService.loadUserByUsername(loginDetails.getUsername());
		String token = jwtGenerator.generateToken(userDetails.getUsername());
		return ResponseEntity.ok(new SuccessResponse(userDetails.getUsername(),token));
	}
	
//	@GetMapping("/forgotPassword")
//	public ResponseEntity<String> forgotPassword(@RequestBody PasswordResetRequest){
//		return ResponseEntity.ok(authService.forgotPassword(newPassword));
//	}
}