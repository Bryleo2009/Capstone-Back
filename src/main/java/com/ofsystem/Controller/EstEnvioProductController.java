package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.EstProduct;
import com.ofsystem.Service.Imple.EstProductServiceImpl;
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
	private EstProductServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<EstProduct>> listar() {
		return new ResponseEntity<List<EstProduct>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstProduct> listarPorId(@PathVariable("id") int id) {
		EstProduct unaEstProduct = service.listarxID(id);
		if(unaEstProduct == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<EstProduct>(unaEstProduct,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody EstProduct dato) {
		EstProduct unaEstProduct = service.listarxID(dato.getIdEstEnvioProduct());
		URI location = null;
		if(unaEstProduct != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaEstProduct.getIdEstEnvioProduct()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdEstEnvioProduct() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdEstEnvioProduct()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<EstProduct> modificar(@RequestBody EstProduct dato) {
		return new ResponseEntity<EstProduct>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		EstProduct unaEstProduct = service.listarxID(id);
		if(unaEstProduct == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
