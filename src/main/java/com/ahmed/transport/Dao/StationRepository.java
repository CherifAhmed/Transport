package com.ahmed.transport.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import com.ahmed.transport.entities.Station;
@CrossOrigin("*")
@RepositoryRestResource
public interface StationRepository extends JpaRepository<Station, Long>{	
	  @RestResource(path ="/selectedStation")
	  public Station findByNameContains(@Param("mc") String mc);
	  @RestResource(path="/listByTrue")
	  public List<Station> findByMultistationIsTrue();
	  @Query(value="SELECT metro_line.numero,station.* FROM `station`INNER JOIN metro_line ON station.metro_id = metro_line.id AND station.name='El Fel'",nativeQuery = true)
	  List<Station> getSelectStation();
	
}
