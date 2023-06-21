package com.ofsystem.Capstone.Controller.Comprobante;

import com.ofsystem.Capstone.Service.Imple.Enums.TipoPagoServiceImpl;
import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Model.Enums.TipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/TipoPagos")
public class TipoPagoController {

	@Autowired
	private TipoPagoServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<TipoPago>> listar() {
		return new ResponseEntity<List<TipoPago>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoPago> listarPorId(@PathVariable("id") int id) {
		TipoPago unaTipoPago = service.listarxID(id);
		if(unaTipoPago == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<TipoPago>(unaTipoPago,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody TipoPago dato) {
		TipoPago unaTipoPago = service.listarxID(dato.getIdTp());
		URI location = null;
		if(unaTipoPago != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTipoPago.getIdTp()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdTp() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdTp()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<TipoPago> modificar( @RequestBody TipoPago dato) {		
		return new ResponseEntity<TipoPago>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		TipoPago unaTipoPago = service.listarxID(id);
		if(unaTipoPago == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
