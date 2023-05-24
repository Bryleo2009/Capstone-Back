package com.ofsystem.Controller.Usuario;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Usuario.Trabajador;
import com.ofsystem.Service.Imple.Usuario.TrabajadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Trabajadors")
public class TrabajadorController {

	@Autowired
	private TrabajadorServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Trabajador>> listar() {
		return new ResponseEntity<List<Trabajador>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trabajador> listarPorId(@PathVariable("id") int id) {
		Trabajador unaTrabajador = service.listarxID(id);
		if(unaTrabajador == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Trabajador>(unaTrabajador,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Trabajador dato) {
		Trabajador unaTrabajador = service.listarxID(dato.getId());
		URI location = null;
		if(unaTrabajador != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTrabajador.getId()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getId() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getId()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Trabajador> modificar( @RequestBody Trabajador dato) {		
		return new ResponseEntity<Trabajador>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Trabajador unaTrabajador = service.listarxID(id);
		if(unaTrabajador == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
