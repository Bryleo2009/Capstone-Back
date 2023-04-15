package com.ofsystem.Controller;

import com.ofsystem.Exception.ModeloNotFoundException;
import com.ofsystem.Model.TipoCompro;
import com.ofsystem.Service.Imple.TipoComproServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/TipoComprobantes")
public class TipoComproController {

	@Autowired
	private TipoComproServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<TipoCompro>> listar() {
		return new ResponseEntity<List<TipoCompro>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoCompro> listarPorId(@PathVariable("id") int id) {
		TipoCompro unaTipoCompro = service.listarxID(id);
		if(unaTipoCompro == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<TipoCompro>(unaTipoCompro,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody TipoCompro dato) {
		TipoCompro unaTipoCompro = service.listarxID(dato.getIdTc());
		URI location = null;
		if(unaTipoCompro != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTipoCompro.getIdTc()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdTc() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdTc()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<TipoCompro> modificar( @RequestBody TipoCompro dato) {		
		return new ResponseEntity<TipoCompro>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		TipoCompro unaTipoCompro = service.listarxID(id);
		if(unaTipoCompro == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
