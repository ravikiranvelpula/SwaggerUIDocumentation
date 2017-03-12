package com.swag.ui.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwagXchangeService {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {
		System.out.println("Test service has been created");
		return null;
	}
}
