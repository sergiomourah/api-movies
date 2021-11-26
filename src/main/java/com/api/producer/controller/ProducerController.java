package com.api.producer.controller;

import com.api.awards.IntervalAwards;
import com.api.producer.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("/api/producer")
public class ProducerController {

	ProducerService service;

	@GetMapping("/period-interval")
	public ResponseEntity<IntervalAwards> getPeriodInterval() {
		return new ResponseEntity<>(service.getPeriodInterval(), OK);
	}
}
