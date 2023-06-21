package com.ofsystem.Capstone.Controller.Cliente;

import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Model.Cliente.TrazabilidadPedidos;
import com.ofsystem.Capstone.Service.Imple.Cliente.TrazabilidadPedidosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/TrazabilidadPedidoss")
public class TrazabilidadPedidosController {

	@Autowired
	private TrazabilidadPedidosServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<TrazabilidadPedidos>> listar() {
		return new ResponseEntity<List<TrazabilidadPedidos>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TrazabilidadPedidos> listarPorId(@PathVariable("id") int id) {
		TrazabilidadPedidos unaTrazabilidadPedidos = service.listarxID(id);
		if(unaTrazabilidadPedidos == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<TrazabilidadPedidos>(unaTrazabilidadPedidos,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody TrazabilidadPedidos dato) {
		TrazabilidadPedidos unaTrazabilidadPedidos = service.listarxID(dato.getIdTrazaPedidos());
		URI location = null;
		if(unaTrazabilidadPedidos != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTrazabilidadPedidos.getIdTrazaPedidos()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdTrazaPedidos() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdTrazaPedidos()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<TrazabilidadPedidos> modificar( @RequestBody TrazabilidadPedidos dato) {		
		return new ResponseEntity<TrazabilidadPedidos>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		TrazabilidadPedidos unaTrazabilidadPedidos = service.listarxID(id);
		if(unaTrazabilidadPedidos == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
