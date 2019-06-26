package com.ahmed.transport;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.ahmed.transport.Dao.ItineraireRepository;
import com.ahmed.transport.Dao.MetroRepository;
import com.ahmed.transport.Dao.StationRepository;
import com.ahmed.transport.entities.Itineraire;
import com.ahmed.transport.entities.MetroLine;
import com.ahmed.transport.entities.Station;
import com.ahmed.transport.service.StationService;

@SpringBootApplication
public class TransportApplication implements CommandLineRunner {

	
	  @Autowired private StationRepository stationRepository;
	  
	  @Autowired private MetroRepository metroRepository;
	  
	  @Autowired private ItineraireRepository itineraireRepository;
	 
   @Autowired 
   private StationService stationservice;
    
	public static void main(String[] args) {
		SpringApplication.run(TransportApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {		
		  MetroLine metro = new MetroLine(); metro.setNumero(2);
		  metroRepository.save(metro);
		  Station st1=new Station(null,"La jeunesse","10.1827","36.8332",true,metro,null);
		  Station st2=new Station(null,"Cité Olympique","10.1819","36.8386",true,metro,null);
		  Station st3=new Station(null,"10 Décembre","10.1841","36.8443",true,metro,null);
		  Station st4=new Station(null,"El Fel","10.1924","36.8469",true,metro,null);
		 
		  ArrayList<Station> listStations = new ArrayList<>();
		  listStations.add(st1);
		  listStations.add(st2); Itineraire itineraire=new Itineraire();
		  itineraire.setCouleur("red"); itineraire.setStations(listStations);		  
		  ArrayList<Itineraire> listItineraires = new ArrayList<>();
		  listItineraires.add(itineraire);
		  itineraireRepository.save(itineraire); st1.setItineraires(listItineraires);
		  st2.setItineraires(listItineraires);
		  stationRepository.save(st1);
		  stationRepository.save(st2); 
		  stationRepository.save(st3);
		  stationRepository.save(st4);
		  
		  System.out.println("10 Decembre"+stationservice.CalculDistance(36.8787377,10.1692,36.8443, 10.1841));
		  System.out.println("Cité olypique"+stationservice.CalculDistance(36.8787377,10.1692, 36.8386, 10.1819));
		  System.out.println("el Fel"+stationservice.CalculDistance(36.8787377,10.1692,36.8469, 10.1924));
		  System.out.println("La jeunesse"+stationservice.CalculDistance(36.8787377,10.1692, 36.8332, 10.1827));
		// System.out.println("la station la plus proche est "+stationservice.nearetStation("36.8787377","10.16927").toString());
	}
}
