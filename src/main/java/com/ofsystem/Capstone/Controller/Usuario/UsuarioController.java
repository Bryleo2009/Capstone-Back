package com.ofsystem.Capstone.Controller.Usuario;

import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Model.Usuario.Usuario;
import com.ofsystem.Capstone.Service.Imple.Usuario.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		return new ResponseEntity<List<Usuario>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") int id) {
		Usuario unaUsuario = service.listarxID(id);
		if(unaUsuario == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Usuario>(unaUsuario,HttpStatus.OK);
	}

	@GetMapping("/byUsername/{username}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("username") String username) {
		Usuario unaUsuario = service.findByUsername(username);
		if(unaUsuario == null) {
			throw new ModeloNotFoundException("username NO ENCONTRADO: " + username);
		}
		return new ResponseEntity<Usuario>(unaUsuario,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Usuario dato) {
		Usuario unaUsuario = service.listarxID(dato.getIdUser());
		URI location = null;
		if(unaUsuario != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaUsuario.getIdUser()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdUser() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdUser()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Usuario> modificar( @RequestBody Usuario dato) {		
		return new ResponseEntity<Usuario>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Usuario unaUsuario = service.listarxID(id);
		if(unaUsuario == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
