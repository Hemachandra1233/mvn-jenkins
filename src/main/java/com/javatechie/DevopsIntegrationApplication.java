package com.javatechie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class DevopsIntegrationApplication {

	@Autowired
	PersonsRepository repo; 
	
	@GetMapping("/persons")
	public List<Persons> getPersons(){
		List<Persons> result = new ArrayList<Persons>();
		Iterable<Persons> iterable = repo.findAll();
		Iterator<Persons> iter = iterable.iterator();
		while(iter.hasNext()) {
			result.add(iter.next());
		}
		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(DevopsIntegrationApplication.class, args);
	}

	@GetMapping
	public String getHello() {
		return "Hello Swap Hema";
	}
}
