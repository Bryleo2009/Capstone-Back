package com.ofsystem.Controller;

import com.ofsystem.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Cliente;
import com.ofsystem.Service.Imple.ClienteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Clientes")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		return new ResponseEntity<List<Cliente>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable("id") int id) {
		Cliente unaCliente = service.listarxID(id);
		if(unaCliente == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Cliente>(unaCliente,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Cliente dato) {
		Cliente unaCliente = service.listarxID(dato.getIdCliente());
		URI location = null;
		if(unaCliente != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaCliente.getIdCliente()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdCliente() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdCliente()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente dato) {		
		return new ResponseEntity<Cliente>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Cliente unaCliente = service.listarxID(id);
		if(unaCliente == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
