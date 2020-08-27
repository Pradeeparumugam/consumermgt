package com.dxctraining.consumermgt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.consumermgt.dto.ComplaintDto;
import com.dxctraining.consumermgt.dto.ConsumerDto;
import com.dxctraining.consumermgt.dto.CreateConsumerRequest;
import com.dxctraining.consumermgt.entities.Consumer;
import com.dxctraining.consumermgt.service.ConsumerService;


@RestController
@RequestMapping("/consumer")
public class ConsumerRestController {

	@Autowired
	 ConsumerService service;
	@Autowired
	RestTemplate rest;

	@PostMapping("/addnew")
	public ConsumerDto create(@RequestBody CreateConsumerRequest req) {
		int id = req.getId();
		String name = req.getName();
		Consumer c1 = new Consumer(id, name);
		c1 = service.addConsumer(c1);
		ConsumerDto dto=toConsumerDto(c1);
		return dto;

	}
	@GetMapping("/getconsumer/{id}")
	public ConsumerDto get(@PathVariable("id") int id) {
		Consumer c1=service.findById(id);
		ConsumerDto dto=toConsumerDto(c1);
		return dto;
	}

	public ConsumerDto toConsumerDto(Consumer consumer) { 
		ConsumerDto dto=new ConsumerDto(); 
		dto.setId(consumer.getCid()); 
		dto.setName(consumer.getName()); 
		return dto;
	}
	/*public ComplaintDto fetchFromConsumerAppById(int id) {
        String url = "http://localhost:8585/complaint/findbyid/" + id;
        ComplaintDto dto = rest.getForObject(url, ComplaintDto.class);
        return dto;
	}*/

}
