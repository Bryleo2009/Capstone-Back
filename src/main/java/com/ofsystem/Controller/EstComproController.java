package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.EstCompro;
import com.ofsystem.Service.Imple.EstComproServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/EstCompros")
public class EstComproController {

	@Autowired
	private EstComproServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<EstCompro>> listar() {
		return new ResponseEntity<List<EstCompro>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstCompro> listarPorId(@PathVariable("id") int id) {
		EstCompro unaEstCompro = service.listarxID(id);
		if(unaEstCompro == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<EstCompro>(unaEstCompro,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody EstCompro dato) {
		EstCompro unaEstCompro = service.listarxID(dato.getIdEstCompro());
		URI location = null;
		if(unaEstCompro != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaEstCompro.getIdEstCompro()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdEstCompro() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdEstCompro()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<EstCompro> modificar( @RequestBody EstCompro dato) {		
		return new ResponseEntity<EstCompro>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		EstCompro unaEstCompro = service.listarxID(id);
		if(unaEstCompro == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
