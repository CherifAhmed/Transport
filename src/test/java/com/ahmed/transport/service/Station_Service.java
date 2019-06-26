package com.ahmed.transport.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ahmed.transport.Dao.StationRepository;
@RunWith(MockitoJUnitRunner.class)
public class Station_Service {
    @Mock
    StationRepository stationRepository;
    @InjectMocks
    StationService stationService;
	@Test
	public void test_nearetStation() {
		
	}

}
