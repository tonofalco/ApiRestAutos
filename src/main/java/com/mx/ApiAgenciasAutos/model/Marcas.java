package com.mx.ApiAgenciasAutos.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE MARCA_AUTO(
   ID NUMBER PRIMARY KEY,
   NOMBRE VARCHAR2(90) NOT NULL,
   ORIGEN VARCHAR2(70) NOT NULL,
   FUNDACION DATE
);
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="MARCA_AUTO")
public class Marcas {
	
	@Id
	@Column(name="ID")
	private Long idMar;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="ORIGEN")
	private String origen;
	
	@Column(name="FUNDACION")
	private Date fundacion;
	
	//Cardinalidad -- 1 marca tiene muchos modelos
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	@JsonIgnore //nos sirve para ignorar una propiedad o una lista de propiedades
	List<Modelos> lista = new ArrayList<>();
	

}
