package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	
	@LocalServerPort
	private int port;
	
	private static String baseUrl = "http://localhost";
	
	@Autowired
	private static RestTemplate restTemplate;
	
	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

}
