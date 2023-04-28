package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Marca;
import com.ofsystem.Service.Imple.MarcaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Marcas")
public class MarcaController {

	@Autowired
	private MarcaServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Marca>> listar() {
		return new ResponseEntity<List<Marca>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Marca> listarPorId(@PathVariable("id") int id) {
		Marca unaMarca = service.listarxID(id);
		if(unaMarca == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Marca>(unaMarca,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Marca dato) {
		Marca unaMarca = service.listarxID(dato.getIdMarca());
		URI location = null;
		if(unaMarca != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaMarca.getIdMarca()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdMarca() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdMarca()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Marca> modificar( @RequestBody Marca dato) {		
		return new ResponseEntity<Marca>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Marca unaMarca = service.listarxID(id);
		if(unaMarca == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
