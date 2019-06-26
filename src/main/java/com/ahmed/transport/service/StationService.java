package com.ahmed.transport.service;

import java.util.Optional;

import com.ahmed.transport.entities.Station;

public interface StationService {
public Station nearetStation(String lat, String lon);
public double CalculDistance(double lat1,double lon1,double lat2,double lon2);
}
