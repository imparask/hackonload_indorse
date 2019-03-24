package com.stir.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Trains {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String train_name;
	private String station_from;
	private String station_to;
	private String pnr;
	private String coach_seat;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getCoach_seat() {
		return coach_seat;
	}
	public void setCoach_seat(String coach_seat) {
		this.coach_seat = coach_seat;
	}
	public List<Stations> getStation() {
		return station;
	}
	public void setStation(List<Stations> station) {
		this.station = station;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="train_station", joinColumns=@JoinColumn(name="train_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="station_id", referencedColumnName="id"))
	private List<Stations> station;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getStation_from() {
		return station_from;
	}
	public void setStation_from(String station_from) {
		this.station_from = station_from;
	}
	public String getStation_to() {
		return station_to;
	}
	public void setStation_to(String station_to) {
		this.station_to = station_to;
	}
	@Override
	public String toString() {
		return "Trains [train_num=" + id + ", train_name=" + train_name + ", station_from=" + station_from
				+ ", station_to=" + station_to + ", PNR=" + pnr + ", coach_seat=" + coach_seat + ", station=" + station
				+ "]";
	}
	
	
}
