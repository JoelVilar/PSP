package com.juanxxiii.login.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.juanxxiii.login.domain.errors.UserAlreadyExistsException;
import com.juanxxiii.login.domain.errors.UserIsNotCorrectException;
import com.juanxxiii.login.entities.User;
import com.juanxxiii.login.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	@ResponseBody
	public String login(@RequestParam String name,@RequestParam String password) throws UserIsNotCorrectException {
		User user = new User(name, password);
		if (this.userService.isUserCorrect(user) > Long.valueOf(0)) {
			return "Loggeado correctamente";
		} else throw new UserIsNotCorrectException("Datos del usuario incorrectos.");
	}
	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return this.userService.getUser(id).get();
	}
	
	@PutMapping("/register")
	public User register(@RequestBody User user) throws UserAlreadyExistsException {
		Optional<User> optionalUser = this.userService.createUser(user);
		if(optionalUser.isEmpty())
			throw new UserAlreadyExistsException("El usuario introducido ya existe.");
		else return optionalUser.get();
	}
}
