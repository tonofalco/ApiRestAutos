package com.mx.ApiAgenciasAutos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE MODELO_AUTO(
   ID NUMBER PRIMARY KEY,
   NOMBRE VARCHAR2(80) NOT NULL,
   TRASMISION VARCHAR2(90) NOT NULL,
   PRECIO NUMBER NOT NULL,
   ID_MARCA NUMBER NOT NULL,
   FOREIGN KEY(ID_MARCA) REFERENCES MARCA_AUTO(ID)
);
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="MODELO_AUTO")
public class Modelos {
	
	@Id
	@Column(name="ID")
	private Long idMod;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TRASMISION")
	private String transmision;
	
	@Column(name="PRECIO")
	private Double precio;
	
	//Cardinalidad -- Muchos modelos pertenecen a una marca
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_MARCA")
	Marcas marca;
	
	//fetch -- Indicamos como debe ser cargada la entidad
	// FetchType.EAGER -- Indicamos que la relacion debe de ser cargada al momento
	
}
