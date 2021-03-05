package com.juanxxiii.login;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.juanxxiii.login.controlador.UserService;
import com.juanxxiii.login.entities.User;

@SpringBootTest
class LoginApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("Loggeado correctamente", UserService.getInstance().login(new User("admin","admin")));
		assertEquals("Usuario incorrecto", UserService.getInstance().login(new User("dmin","min")));
	}

}
