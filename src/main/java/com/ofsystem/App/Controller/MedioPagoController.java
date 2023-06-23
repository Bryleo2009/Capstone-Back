package com.ofsystem.App.Controller;


import com.ofsystem.App.Model.MedioPago;
import com.ofsystem.App.Service.Impl.MedioPagoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/MedioPagos")
public class MedioPagoController {

	@Autowired
	private MedioPagoServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<MedioPago>> listar() {
		return new ResponseEntity<List<MedioPago>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedioPago> listarPorId(@PathVariable("id") int id) {
		MedioPago unaMedioPago = service.listarxID(id);
		if(unaMedioPago == null) {
			
		}		
		return new ResponseEntity<MedioPago>(unaMedioPago,HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody MedioPago dato) {
		MedioPago unaMedioPago = service.listarxID(dato.getIdMedioPago());
		URI location = null;
		if(unaMedioPago != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaMedioPago.getIdMedioPago()).toUri();
			} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdMedioPago()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<MedioPago> modificar( @RequestBody MedioPago dato) {		
		return new ResponseEntity<MedioPago>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		MedioPago unaMedioPago = service.listarxID(id);
		if(unaMedioPago == null) {
			
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
