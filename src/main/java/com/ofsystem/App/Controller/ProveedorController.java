package com.ofsystem.App.Controller;


import com.ofsystem.App.Model.Proveedor;
import com.ofsystem.App.Service.Impl.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Proveedors")
public class ProveedorController {

	@Autowired
	private ProveedorServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Proveedor>> listar() {
		return new ResponseEntity<List<Proveedor>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> listarPorId(@PathVariable("id") String id) {
		Proveedor unaProveedor = service.listarxID(id);
		if(unaProveedor == null) {
			
		}		
		return new ResponseEntity<Proveedor>(unaProveedor,HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Proveedor dato) {
		Proveedor unaProveedor = service.listarxID(dato.getRuc());
		URI location = null;
		if(unaProveedor != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaProveedor.getRuc()).toUri();
			} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getRuc()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Proveedor> modificar( @RequestBody Proveedor dato) {		
		return new ResponseEntity<Proveedor>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") String id) {
		Proveedor unaProveedor = service.listarxID(id);
		if(unaProveedor == null) {
			
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
