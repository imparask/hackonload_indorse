package com.stir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stir.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
