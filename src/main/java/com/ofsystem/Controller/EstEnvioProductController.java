package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.EstEnvioProduct;
import com.ofsystem.Service.Imple.EstEnvioProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/EstEnvioProducts")
public class EstEnvioProductController {

	@Autowired
	private EstEnvioProductServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<EstEnvioProduct>> listar() {
		return new ResponseEntity<List<EstEnvioProduct>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstEnvioProduct> listarPorId(@PathVariable("id") int id) {
		EstEnvioProduct unaEstEnvioProduct = service.listarxID(id);
		if(unaEstEnvioProduct == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<EstEnvioProduct>(unaEstEnvioProduct,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody EstEnvioProduct dato) {
		EstEnvioProduct unaEstEnvioProduct = service.listarxID(dato.getIdEstEnvioProduct());
		URI location = null;
		if(unaEstEnvioProduct != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaEstEnvioProduct.getIdEstEnvioProduct()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdEstEnvioProduct() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdEstEnvioProduct()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<EstEnvioProduct> modificar( @RequestBody EstEnvioProduct dato) {		
		return new ResponseEntity<EstEnvioProduct>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		EstEnvioProduct unaEstEnvioProduct = service.listarxID(id);
		if(unaEstEnvioProduct == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
