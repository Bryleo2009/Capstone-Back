package com.ofsystem.Controller;

import com.ofsystem.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Rol;
import com.ofsystem.Service.Imple.RolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Rols")
public class RolController {

	@Autowired
	private RolServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar() {
		return new ResponseEntity<List<Rol>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rol> listarPorId(@PathVariable("id") int id) {
		Rol unaRol = service.listarxID(id);
		if(unaRol == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Rol>(unaRol,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Rol dato) {
		Rol unaRol = service.listarxID(dato.getIdRol());
		URI location = null;
		if(unaRol != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaRol.getIdRol()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdRol() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdRol()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Rol> modificar( @RequestBody Rol dato) {		
		return new ResponseEntity<Rol>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Rol unaRol = service.listarxID(id);
		if(unaRol == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
