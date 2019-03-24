package com.stir.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.stir.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	@Modifying
	@Transactional
	@Query(value="insert into train_station values(:vid,:iid)", nativeQuery= true)
	void assignItems(int vid, int iid);
}
