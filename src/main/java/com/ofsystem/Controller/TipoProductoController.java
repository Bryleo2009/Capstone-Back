package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.TipoProducto;
import com.ofsystem.Service.Imple.TipoProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/TipoProductos")
public class TipoProductoController {

	@Autowired
	private TipoProductoServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<TipoProducto>> listar() {
		return new ResponseEntity<List<TipoProducto>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoProducto> listarPorId(@PathVariable("id") int id) {
		TipoProducto unaTipoProducto = service.listarxID(id);
		if(unaTipoProducto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<TipoProducto>(unaTipoProducto,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody TipoProducto dato) {
		TipoProducto unaTipoProducto = service.listarxID(dato.getIdTipoProduc());
		URI location = null;
		if(unaTipoProducto != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTipoProducto.getIdTipoProduc()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdTipoProduc() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdTipoProduc()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<TipoProducto> modificar( @RequestBody TipoProducto dato) {		
		return new ResponseEntity<TipoProducto>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		TipoProducto unaTipoProducto = service.listarxID(id);
		if(unaTipoProducto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
