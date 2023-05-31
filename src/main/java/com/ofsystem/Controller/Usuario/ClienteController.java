package com.ofsystem.Controller.Usuario;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Enums.TipoDoc;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Model.Enums.Rol;
import com.ofsystem.Model.Usuario.Usuario;
import com.ofsystem.Service.Imple.Enums.TipoDocServiceImpl;
import com.ofsystem.Service.Imple.Usuario.ClienteServiceImpl;
import com.ofsystem.Service.Imple.Enums.RolServiceImpl;
import com.ofsystem.Service.Imple.Usuario.UsuarioServiceImpl;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("/Clientes")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl service;
	@Autowired
	private RolServiceImpl serviceRol;
	@Autowired
	private TipoDocServiceImpl tipoDocService;
	@Autowired
	private UsuarioServiceImpl usuarioService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
		Usuario usuario = new Usuario();
		usuario = dato.getIdUserCliente();
		usuario.setEstadoUser(true);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioService.registrar(usuario);
		dato.setIdUserCliente(usuarioService.findByUsername(usuario.getUsername()));
		service.registrar(dato);
		
		return new ResponseEntity<>(HttpStatus.OK);
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

	@GetMapping("/existencia")
	public ResponseEntity<Boolean> exitenciaXCorreo (@RequestParam("correo") String correo){
		return new ResponseEntity<Boolean>(service.existsByCorreo(correo),HttpStatus.OK);
	}

	@GetMapping("/byCorreo/{correo}")
	public ResponseEntity<Cliente> findByCorreo (@PathVariable("correo") String correo){
		return new ResponseEntity<Cliente>(service.findByCorreo(correo),HttpStatus.OK);
	}
}
