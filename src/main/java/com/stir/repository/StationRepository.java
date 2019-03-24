package com.stir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stir.model.Stations;

public interface StationRepository extends JpaRepository<Stations, Integer> {
	List<Stations> findAllByTrainId(int tid);
}
