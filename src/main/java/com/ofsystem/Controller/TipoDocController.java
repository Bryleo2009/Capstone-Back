package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.TipoDoc;
import com.ofsystem.Service.Imple.TipoDocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/TipoDocs")
public class TipoDocController {

	@Autowired
	private TipoDocServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<TipoDoc>> listar() {
		return new ResponseEntity<List<TipoDoc>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDoc> listarPorId(@PathVariable("id") int id) {
		TipoDoc unaTipoDoc = service.listarxID(id);
		if(unaTipoDoc == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<TipoDoc>(unaTipoDoc,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody TipoDoc dato) {
		TipoDoc unaTipoDoc = service.listarxID(dato.getIdTdoc());
		URI location = null;
		if(unaTipoDoc != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTipoDoc.getIdTdoc()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdTdoc() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdTdoc()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<TipoDoc> modificar( @RequestBody TipoDoc dato) {		
		return new ResponseEntity<TipoDoc>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		TipoDoc unaTipoDoc = service.listarxID(id);
		if(unaTipoDoc == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
