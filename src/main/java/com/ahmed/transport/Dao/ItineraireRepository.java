package com.ahmed.transport.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ahmed.transport.entities.Itineraire;

@RepositoryRestResource
public interface ItineraireRepository extends JpaRepository<Itineraire, Long>{

}
