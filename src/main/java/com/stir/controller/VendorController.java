package com.stir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stir.model.Vendor;
import com.stir.repository.VendorRepository;

@RestController
@RequestMapping("rest")
public class VendorController {
	
	@Autowired
	VendorRepository vendorRepository;
	
	@PostMapping("/vendor")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public Vendor createVendor(@RequestBody Vendor vendor) {
		//go to repo(User) and use save method to insert in DB
		return vendorRepository.save(vendor);
	}
	
	@GetMapping("/vendors")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public List<Vendor> getVendors() {
		//go to repo and fetch all users 
		return vendorRepository.findAll();
	}
	
	@CrossOrigin(origins = {"http://localhost:8080"})
	@PostMapping("/assignItems/{vid}/{iid}")
	public void assignItems(@PathVariable("vid") int vid,@PathVariable("iid") int iid){
		vendorRepository.assignItems(vid,iid);
		
	}
}

