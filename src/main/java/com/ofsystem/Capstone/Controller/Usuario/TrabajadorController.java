package com.ofsystem.Capstone.Controller.Usuario;

import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Model.Enums.Rol;
import com.ofsystem.Capstone.Model.Enums.TipoDoc;
import com.ofsystem.Capstone.Model.Usuario.Cliente;
import com.ofsystem.Capstone.Model.Usuario.Trabajador;
import com.ofsystem.Capstone.Model.Usuario.Usuario;
import com.ofsystem.Capstone.Service.Imple.Enums.RolServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Enums.TipoDocServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Usuario.TrabajadorServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Usuario.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/Trabajadors")
public class TrabajadorController {

	@Autowired
	private TrabajadorServiceImpl service;
	@Autowired
	private RolServiceImpl serviceRol;
	@Autowired
	private TipoDocServiceImpl tipoDocService;
	@Autowired
	private UsuarioServiceImpl usuarioService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping
	public ResponseEntity<List<Trabajador>> listar() {
		return new ResponseEntity<List<Trabajador>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trabajador> listarPorId(@PathVariable("id") int id) {
		Trabajador unaTrabajador = service.listarxID(id);
		if(unaTrabajador == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Trabajador>(unaTrabajador,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Trabajador dato) {
		Trabajador unaTrabajador = service.listarxID(dato.getId());
		URI location = null;
		if(unaTrabajador != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaTrabajador.getId()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getId() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getId()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/byNum/{num}")
	public ResponseEntity<Cliente> findByNum(@PathVariable("num") String num) {
		Cliente unaEmpleado = service.findByIdUserCliente_Username(num);
		if(num.equals("admin")){
			Rol rol = serviceRol.findByNombreItem("ROLE_SOPORTE");
			Usuario usuario = new Usuario("admin","admin123",true,rol);
			TipoDoc tipoDoc = tipoDocService.listarxID(1);
			unaEmpleado = new Cliente("ofSystem - Nombre","Ofsystem - Apellido", new Date(2000,8,24),"994271287","Sin direccion","150101","bryleo2009@hotmail.com","71850926",usuario,tipoDoc);
		} else if(unaEmpleado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + num);
		}
		return new ResponseEntity<Cliente>(unaEmpleado,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Trabajador> modificar( @RequestBody Trabajador dato) {		
		return new ResponseEntity<Trabajador>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Trabajador unaTrabajador = service.listarxID(id);
		if(unaTrabajador == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
