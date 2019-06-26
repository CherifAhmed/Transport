package com.ahmed.transport.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor 
public class MetroLine implements Serializable {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private int numero;
@JsonIgnore
@OneToMany(mappedBy="metro",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Collection<Station> stations = new ArrayList<>();
}
