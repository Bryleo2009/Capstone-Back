package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.EtiquetaFilter;
import com.ofsystem.Model.Etiquetas;
import com.ofsystem.Service.Imple.EtiquetasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Etiquetas")
public class EtiquetasController {

	@Autowired
	private EtiquetasServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Etiquetas>> listar() {
		return new ResponseEntity<List<Etiquetas>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Etiquetas> listarPorId(@PathVariable("id") int id) {
		Etiquetas unaEtiquetas = service.listarxID(id);
		if(unaEtiquetas == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Etiquetas>(unaEtiquetas,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Etiquetas dato) {
		Etiquetas unaEtiquetas = service.listarxID(dato.getIdEtiqueta());
		URI location = null;
		if(unaEtiquetas != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaEtiquetas.getIdEtiqueta()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdEtiqueta() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdEtiqueta()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Etiquetas> modificar( @RequestBody Etiquetas dato) {		
		return new ResponseEntity<Etiquetas>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Etiquetas unaEtiquetas = service.listarxID(id);
		if(unaEtiquetas == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/colors")
	public ResponseEntity<List<EtiquetaFilter>> getColor() {
		return new ResponseEntity<List<EtiquetaFilter>>(service.getColor(),HttpStatus.OK);
	}
}
