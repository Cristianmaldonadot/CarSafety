package com.carsafety.controllers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carsafety.controllers.request.CreateUserDTO;
import com.carsafety.interfaces.IUsuario;
import com.carsafety.model.ERole;
import com.carsafety.model.RolEntity;
import com.carsafety.model.Usuario;

import jakarta.validation.Valid;

@RestController
public class PrincipalController {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private IUsuario userRepository;

	@GetMapping("/hello")
	public String hola() {
		return "Hello World Not Security";
	}
	
	
	@GetMapping("/helloSecured")
	public String holasecured() {
		return "Hello World Secured";
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
		
		Set<RolEntity> roles = createUserDTO.getRoles().stream()
				.map(role -> RolEntity.builder()
						.name(ERole.valueOf(role))
						.build())
				.collect(Collectors.toSet());
		
		Usuario userEntity = Usuario.builder()
				.username(createUserDTO.getUsername())
				.password(encoder.encode(createUserDTO.getPassword()))
				.email(createUserDTO.getEmail())
				.roles(roles)
				.build();
		
		userRepository.save(userEntity);
		
		return ResponseEntity.ok(userEntity);
					
	}
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam String id) {
		userRepository.deleteById(Long.parseLong(id));
		return "Se ha borrado el usuario con id ".concat(id);
	}
}
