package com.mx.ApiAgenciasAutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiAgenciasAutos.model.Marcas;
import com.mx.ApiAgenciasAutos.service.MarcasServImp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "MarcasWs")
@CrossOrigin
public class MarcasWs {

	@Autowired
	MarcasServImp marcasImp;

	// http://localhost:9000/MarcasWs/listar
	@GetMapping(path = "listar")
	public List<Marcas> listar() {
		return marcasImp.listar();
	}

	// http://localhost:9000/MarcasWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Marcas marca) {

		boolean response = marcasImp.guardar(marca);

		if (response == true)
			return new ResponseEntity<>("El nombre o el ID ya exiten. ingresa otro", HttpStatus.OK);
		else
			return new ResponseEntity<>(marca, HttpStatus.CREATED);

	}

	// http://localhost:9000/MarcasWs/buscar
	@PostMapping(path = "buscar")
	public Marcas buscar(@RequestBody Marcas marca) {
		return marcasImp.buscar(marca.getIdMar());
	}

	// http://localhost:9000/MarcasWs/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Marcas marca) {

		boolean response = marcasImp.editar(marca);

		if (response == false)
			return new ResponseEntity<>("El id no se encuentra en la BD", HttpStatus.OK);
		else
			return new ResponseEntity<>(marca, HttpStatus.CREATED);
	}

	// http://localhost:9000/MarcasWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Marcas marca) {

		boolean response = marcasImp.eliminar(marca.getIdMar());

		if (response == false)
			return new ResponseEntity<>("El id no se encuentra en la BD", HttpStatus.OK);
		else
			return new ResponseEntity<>("Eliminado el registro con id " + marca.getIdMar(), HttpStatus.CREATED);
	}

}
