package com.ofsystem.Controller;

import com.ofsystem.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Categoria;
import com.ofsystem.Service.Imple.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Categorias")
public class CategoriaController {

	@Autowired
	private CategoriaServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		return new ResponseEntity<List<Categoria>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> listarPorId(@PathVariable("id") int id) {
		Categoria unaCategoria = service.listarxID(id);
		if(unaCategoria == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Categoria>(unaCategoria,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Categoria dato) {
		Categoria unaCategoria = service.listarxID(dato.getIdCateg());
		URI location = null;
		if(unaCategoria != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaCategoria.getIdCateg()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdCateg() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdCateg()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Categoria> modificar( @RequestBody Categoria dato) {		
		return new ResponseEntity<Categoria>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Categoria unaCategoria = service.listarxID(id);
		if(unaCategoria == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
