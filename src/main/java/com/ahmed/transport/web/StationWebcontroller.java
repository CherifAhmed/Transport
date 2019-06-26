package com.ahmed.transport.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.transport.Dao.StationRepository;
import com.ahmed.transport.entities.Station;
import com.ahmed.transport.service.StationService;

@RestController
public class StationWebcontroller {
private StationService stationService;
@Autowired
private StationRepository stationRepository;

public StationWebcontroller(StationService stationService) {
	this.stationService = stationService;
}

@GetMapping(value="/stations/{lat}/long/{lon}")
public Station nearest(@PathVariable("lat") String lat,@PathVariable("lon") String lon)  {
	return stationService.nearetStation(lat,lon); 
}
@GetMapping(value="/name/{name}")
public Station getStationByName(@PathVariable("name") String name) {
return stationRepository.findByNameContains(name);
}
@GetMapping(value="/stations/all")
public List<Station> getStations(){
	return stationRepository.getSelectStation();
}
}
