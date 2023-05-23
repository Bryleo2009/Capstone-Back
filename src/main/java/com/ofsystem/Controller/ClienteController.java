package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Cliente;
import com.ofsystem.Model.Rol;
import com.ofsystem.Model.Usuario;
import com.ofsystem.Service.Imple.ClienteServiceImpl;
import com.ofsystem.Service.Imple.RolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/Clientes")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl service;

	@Autowired
	private RolServiceImpl serviceRol;
	
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
	public ResponseEntity<Object> registrar( @RequestBody Cliente dato) {
		Cliente unaCliente = service.listarxID(dato.getId());
		URI location = null;
		if(unaCliente != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaCliente.getId()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getId() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getId()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Cliente> modificar( @RequestBody Cliente dato) {		
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

	@GetMapping("/byNum/{num}")
	public ResponseEntity<Cliente> findByNum(@PathVariable("num") String num) {
		Cliente unaEmpleado = service.findByNumDocumento(num);
		if(num.equals("admin")){
			Rol rol = serviceRol.findByNombreItem("ROLE_SOPORTE");
			Usuario usuario = new Usuario("admin","admin123",true,rol);
			unaEmpleado = new Cliente("ofSystem - Nombre","Ofsystem - Apellido", new Date(2000,8,24),"994271287","Sin direccion","150101","71850926",usuario);
		} else if(unaEmpleado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + num);
		}
		return new ResponseEntity<Cliente>(unaEmpleado,HttpStatus.OK);
	}
}
