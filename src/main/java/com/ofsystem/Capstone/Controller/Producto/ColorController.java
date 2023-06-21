package com.ofsystem.Capstone.Controller.Producto;

import com.ofsystem.Capstone.Mapper.Filter.ColorFilter;
import com.ofsystem.Capstone.Service.Imple.Enums.ColorServiceImpl;
import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Model.Enums.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Colors")
public class ColorController {

	@Autowired
	private ColorServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Color>> listar() {
		return new ResponseEntity<List<Color>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Color> listarPorId(@PathVariable("id") int id) {
		Color unaColor = service.listarxID(id);
		if(unaColor == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Color>(unaColor,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Color dato) {
		Color unaColor = service.listarxID(dato.getIdColor());
		URI location = null;
		if(unaColor != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaColor.getIdColor()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdColor() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdColor()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Color> modificar( @RequestBody Color dato) {		
		return new ResponseEntity<Color>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Color unaColor = service.listarxID(id);
		if(unaColor == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/colors")
	public ResponseEntity<List<ColorFilter>> getColor() {
		return new ResponseEntity<List<ColorFilter>>(service.getColor(),HttpStatus.OK);
	}

	@GetMapping("/activas/{id}")
	public ResponseEntity<List<ColorFilter>> listarPorIdActivas(@PathVariable("id") int id) {
		System.out.println(service.listarColoresxID(id));
		return new ResponseEntity<List<ColorFilter>>( service.listarColoresxID(id),HttpStatus.OK);
	}
}
