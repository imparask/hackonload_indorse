package com.stir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stir.model.Inventory;
import com.stir.repository.InventoryRepository;

@RestController
@RequestMapping("rest")
public class InventoryController {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@GetMapping("/items")
	@CrossOrigin(origins = {"http://localhost:8080"})
	public List<Inventory> getItems() {
		//go to repo and fetch all users 
		return inventoryRepository.findAll();
	}
	
}

