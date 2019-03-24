package com.stir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stir.model.Stations;
import com.stir.repository.StationRepository;

@RestController
@RequestMapping("rest")
public class StationController {
	
	@Autowired
	private StationRepository stationRepository;
	
	@GetMapping("/stations")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public List<Stations> getStations(){
		// go to repo
		return stationRepository.findAll();
	}
	
	@GetMapping("/stations/{id}")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public List<Stations> getStationsAsPerTrainNum(@PathVariable("id") int tid){
		// go to repo and fetch stations of a particular train
		return stationRepository.findAllByTrainId(tid);
	}
	
	
}
