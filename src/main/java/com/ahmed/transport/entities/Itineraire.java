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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data  @NoArgsConstructor @AllArgsConstructor
public class Itineraire implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String couleur;

@ManyToMany(mappedBy="itineraires")
private Collection<Station> stations = new ArrayList<>();



}
