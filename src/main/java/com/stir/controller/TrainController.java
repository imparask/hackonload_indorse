package com.stir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stir.model.Trains;
import com.stir.repository.TrainRepository;

@RestController
@RequestMapping("rest")
public class TrainController {
	
	@Autowired
	TrainRepository trainRepository;
	
	@GetMapping("/trains")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public List<Trains> getTrains() {
		//go to repo and fetch all trains
		return trainRepository.findAll();
	}
	
	@GetMapping("/trains/{pnr}")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public List<Trains> getTrainsAsPerPNR(@PathVariable("pnr") String pnr) {
		//go to repo and fetch all trains
		return trainRepository.findByPnr(pnr);
	}

	@CrossOrigin(origins = {"http://localhost:8080"})
	@PostMapping("/assignStation/{tid}/{sid}")
	public void assignStation(@PathVariable("tid") int tid,@PathVariable("sid") int sid){
		trainRepository.assignStation(tid,sid);
		
	}
}
