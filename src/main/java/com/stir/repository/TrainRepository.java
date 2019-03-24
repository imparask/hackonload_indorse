package com.stir.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.stir.model.Trains;

public interface TrainRepository extends JpaRepository<Trains, Integer> {
	@Modifying
	@Transactional
	@Query(value="insert into train_station values(:tid,:sid)", nativeQuery= true)
	void assignStation(int tid, int sid);
	
	List<Trains> findByPnr(String pnr);
}
