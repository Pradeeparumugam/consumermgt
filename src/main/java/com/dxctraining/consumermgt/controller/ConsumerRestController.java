package com.dxctraining.consumermgt.controller;


import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.consumermgt.dto.ConsumerDto;
import com.dxctraining.consumermgt.dto.CreateConsumerRequest;
import com.dxctraining.consumermgt.entities.Consumer;
import com.dxctraining.consumermgt.service.ConsumerService;

@Validated
@RestController
@RequestMapping("/consumer")
public class ConsumerRestController {

	@Autowired
	 ConsumerService service;
	@Autowired
	RestTemplate rest;

	@PostMapping("/addnew")
	public ConsumerDto create(@RequestBody CreateConsumerRequest req) {
		@NotBlank
		String name = req.getName();
		@NotBlank
		Consumer c1 = new Consumer(name);
		c1 = service.addConsumer(c1);
		ConsumerDto dto=toConsumerDto(c1);
		return dto;

	}
	@GetMapping("/getconsumer/{id}")
	public ConsumerDto get(@Valid @NotNull @PathVariable("id") int id) {
		Consumer c1=service.findConsumerById(id);
		ConsumerDto dto=toConsumerDto(c1);
		return dto;
	}

	public ConsumerDto toConsumerDto(Consumer consumer) { 
		ConsumerDto dto=new ConsumerDto(); 
		dto.setId(consumer.getId()); 
		dto.setName(consumer.getName()); 
		return dto;
	}
	/*public ComplaintDto fetchFromConsumerAppById(int id) {
        String url = "http://localhost:8585/complaint/findbyid/" + id;
        ComplaintDto dto = rest.getForObject(url, ComplaintDto.class);
        return dto;
	}*/

}
