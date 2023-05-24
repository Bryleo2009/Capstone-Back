package com.ofsystem.Controller.Producto;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.TallaFilter;
import com.ofsystem.Model.Enums.Talla;
import com.ofsystem.Service.Imple.Enums.TallaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Tallas")
public class TallaController {

	@Autowired
	private TallaServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Talla>> listar() {
		return new ResponseEntity<List<Talla>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Talla> listarPorId(@PathVariable("id") int id) {
		Talla unaTalla = service.listarxID(id);
		if(unaTalla == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Talla>(unaTalla,HttpStatus.OK);
	}

	@GetMapping("/activas/{id}")
	public ResponseEntity<List<TallaFilter>> listarPorIdActivas(@PathVariable("id") int id) {
		List<TallaFilter> unaTalla = service.listarTallasxID(id);
		System.out.println(unaTalla);
		if(unaTalla == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<List<TallaFilter>>(unaTalla,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Talla dato) {
		Talla unaTalla = service.listarxID(dato.getIdTalla());
		URI location = null;
		if(unaTalla != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTalla.getIdTalla()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdTalla() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdTalla()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Talla> modificar( @RequestBody Talla dato) {		
		return new ResponseEntity<Talla>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Talla unaTalla = service.listarxID(id);
		if(unaTalla == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}