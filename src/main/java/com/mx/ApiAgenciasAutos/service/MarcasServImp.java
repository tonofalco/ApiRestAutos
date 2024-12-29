package com.mx.ApiAgenciasAutos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiAgenciasAutos.dao.MarcasDao;
import com.mx.ApiAgenciasAutos.model.Marcas;


@Service
public class MarcasServImp {

	@Autowired
	MarcasDao marcaDao;

	// --LISTAR
	public List<Marcas> listar() {
		return marcaDao.findAll();
	}

	// --GUARDAR
	// Validar que el id no se repita
	@Transactional
	public boolean guardar(Marcas marca) {

		boolean bandera = false;

		for (Marcas v : marcaDao.findAll()) {
			// validar que id no se repita
			if (v.getIdMar().equals(marca.getIdMar())) {
				bandera = true;
				System.out.println("id encontrado");
				break;
			}
			// validar que nombre no se repita
			if (v.getNombre().equals(marca.getNombre())) {
				bandera = true;
				System.out.println("nombre encontrado");
				break;
			}
		}

		if (bandera == false) {
			marcaDao.save(marca);
		}
		return bandera;
	}

	// --BUSCAR
	@Transactional
	public Marcas buscar(long idMarca) {
		return marcaDao.findById(idMarca).orElse(null);
	}

	// --EDITAR
	// Validar que el id exista
	@Transactional
	public boolean editar(Marcas marca) {

		boolean bandera = false;

		for (Marcas m : marcaDao.findAll()) {
			if (m.getIdMar().equals(marca.getIdMar())) {
				bandera = true;
				break;
			}
		}

		if (bandera == true) {
			marcaDao.save(marca);
		}

		return bandera;
	}

	// --EDITAR
	// Validar que el id exista para poder eliminar
	@Transactional
	public boolean eliminar(long idMarca) {

		boolean bandera = false;

		for (Marcas m : marcaDao.findAll()) {
			if (m.getIdMar().equals(idMarca)) {
				bandera = true;
				break;
			}
		}

		if (bandera == true) {
			marcaDao.deleteById(idMarca);

		}
		return bandera;
	}
}
