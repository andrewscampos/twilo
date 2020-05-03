package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ImportContact1Application {

	public static void main(String[] args) {
		SpringApplication.run(ImportContact1Application.class, args);
	}
	
	ArrayList<String> list = new ArrayList<>();
	
	ArrayList<String> status = new ArrayList<>();
	
	@RequestMapping(value = "/reciver", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
	public void reciver(@RequestBody String obs) {
		list.add(obs);
	}
	
	
	@RequestMapping(value = "/reciver", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> getReciver() {
		return list;
	}
	
	@RequestMapping(value = "/status",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,  method = RequestMethod.POST)
	public void status(@RequestBody String obs) {
		status.add(obs);
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getStatus() {
		return  new ResponseEntity<List<String>>(status, HttpStatus.CREATED);
	}
}
