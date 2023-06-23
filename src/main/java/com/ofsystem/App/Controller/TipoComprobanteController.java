package com.ofsystem.App.Controller;


import com.ofsystem.App.Model.TipoComprobante;
import com.ofsystem.App.Service.Impl.TipoComprobanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/TipoComprobantes")
public class TipoComprobanteController {

	@Autowired
	private TipoComprobanteServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<TipoComprobante>> listar() {
		return new ResponseEntity<List<TipoComprobante>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoComprobante> listarPorId(@PathVariable("id") int id) {
		TipoComprobante unaTipoComprobante = service.listarxID(id);
		if(unaTipoComprobante == null) {
			
		}		
		return new ResponseEntity<TipoComprobante>(unaTipoComprobante,HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody TipoComprobante dato) {
		TipoComprobante unaTipoComprobante = service.listarxID(dato.getIdTipoComp());
		URI location = null;
		if(unaTipoComprobante != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTipoComprobante.getIdTipoComp()).toUri();
			} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdTipoComp()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<TipoComprobante> modificar( @RequestBody TipoComprobante dato) {		
		return new ResponseEntity<TipoComprobante>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		TipoComprobante unaTipoComprobante = service.listarxID(id);
		if(unaTipoComprobante == null) {
			
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
