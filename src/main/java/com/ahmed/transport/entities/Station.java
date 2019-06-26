package com.ahmed.transport.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Station implements Serializable  {
	
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String name;
private String longitude;
private String latitude;
private boolean multistation;

@ManyToOne
private MetroLine metro ;
@JsonIgnore
@ManyToMany @JoinTable(name="STA_ITI")
private Collection<Itineraire> itineraires = new ArrayList<>();




}
