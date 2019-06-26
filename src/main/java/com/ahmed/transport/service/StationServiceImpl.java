package com.ahmed.transport.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.transport.Dao.StationRepository;
import com.ahmed.transport.entities.Station;

import lombok.RequiredArgsConstructor;

@Service 
public class StationServiceImpl implements StationService {
	@Autowired
private StationRepository stationRepository;

@Override
public Station nearetStation( String lat, String lon)  {
	  
	Station station = new Station();
	 double d=5000000;
	 Map<String,Double> min_distance=new HashMap();
		  stationRepository.findAll().stream().forEach(s->{
			  min_distance.put(s.getName(), calculDistance_betweenTowCoor(Double.parseDouble(lat) , 
					  Double.parseDouble(lon) , Double.parseDouble(s.getLatitude()),
                      Double.parseDouble(s.getLongitude())));
			 });
		  System.out.println(min_distance);
		  Double min = Collections.min(min_distance.values());
		  String key = Collections.min(min_distance.entrySet(), Map.Entry.comparingByValue()).getKey();  
		  System.out.println("LE MIN est ="+ min+ " \nKey:"+key);
	return stationRepository.findByNameContains(key);
}


     private static double calculDistance_betweenTowCoor(double lat1 , double lon1 ,double lat2, double lon2) {
    	 final double R = 6371e3; // meters
    	 double lat1Radians = Math.toRadians(lat2);
    	 double lat2Radians = Math.toRadians(lat1);
    	 double deltaLat=Math.toRadians(lat2-lat1);
    	 double deltaLong=Math.toRadians(lon2-lon1);
    	 double a = Math.sin(deltaLat/2)* Math.sin(deltaLat/2) + Math.cos(lat1Radians) *Math.cos(lat2Radians) * Math.sin(deltaLong/2) * Math.sin(deltaLong/2);
    	 double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
    	 double d = R*c;
    	 return d;
     }


	@Override
	public double CalculDistance(double lat1, double lon1, double lat2, double lon2) {
		
		return calculDistance_betweenTowCoor(lat1 , lon1 , lat2, lon2) ;
	}
}
