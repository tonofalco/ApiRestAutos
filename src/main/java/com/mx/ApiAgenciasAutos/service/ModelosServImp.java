package com.mx.ApiAgenciasAutos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiAgenciasAutos.dao.ModelosDao;
import com.mx.ApiAgenciasAutos.model.Marcas;
import com.mx.ApiAgenciasAutos.model.Modelos;

@Service
public class ModelosServImp {

	@Autowired
	ModelosDao modeloDao;

	public List<Modelos> listar() {
		return modeloDao.findAll();
	}

	// --GUARDAR
	// VALIDAR EL IDMODELO, NOMBRE NO SE REPITAN Y QUE EL IDMARCA EXISTA
	@Transactional
	public boolean guardar(Modelos modelo) {

		boolean bandera = false;
		boolean bandera2 = false;

		for (Modelos m : modeloDao.findAll()) {
			// validar que id no se repita
			if (m.getIdMod().equals(modelo.getIdMod())) {
				bandera = true;
				System.out.println("id encontrado");
				break;
			}
			// validar que nombre no se repita
			if (m.getNombre().equals(modelo.getNombre())) {
				bandera = true;
				break;
			}

			if (m.getMarca().getIdMar().equals(null)) {
				bandera = true;
				System.out.println("no hay id marc");
				break;
			}
		}

		if (bandera == false) {
			modeloDao.save(modelo);
		}
		return bandera;
	}

	// --BUSCAR
	@Transactional
	public Modelos buscar(long idModelo) {
		return modeloDao.findById(idModelo).orElse(null);
	}

	// --EDITAR
	// Validar que el id exista
	@Transactional
	public boolean editar(Modelos modelo) {

		boolean bandera = false;

		for (Modelos m : modeloDao.findAll()) {
			if (m.getIdMod().equals(modelo.getIdMod())) {
				bandera = true;
				break;
			}
		}

		if (bandera == true) {
			modeloDao.save(modelo);
		}

		return bandera;
	}

	// --EDITAR
	// Validar que el id exista para poder eliminar
	@Transactional
	public boolean eliminar(long idModelo) {

		boolean bandera = false;

		for (Modelos m : modeloDao.findAll()) {
			if (m.getIdMod().equals(idModelo)) {
				bandera = true;
				break;
			}
		}

		if (bandera == true) {
			modeloDao.deleteById(idModelo);

		}
		return bandera;
	}
}
