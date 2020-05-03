package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
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
	
	ArrayList<Object> list = new ArrayList<>();
	
	ArrayList<Object> status = new ArrayList<>();
	
	@RequestMapping(value = "/reciver", method = RequestMethod.POST)
	public void reciver(@RequestBody Object obs) {
		list.add(obs);
	}
	
	
	@RequestMapping(value = "/reciver", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Object> getReciver() {
		return list;
	}
	
	@RequestMapping(value = "/status",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,  method = RequestMethod.POST)
	public void status(@RequestBody Object obs) {
		status.add(obs);
	}

	@ResponseBody
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ArrayList<Object> getStatus() {
		return status;
	}
}
