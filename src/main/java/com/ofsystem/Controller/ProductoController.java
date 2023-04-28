package com.ofsystem.Controller;

import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.ProductoFilter;
import com.ofsystem.Model.Producto;
import com.ofsystem.Service.Imple.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/Productos")
public class ProductoController {

	@Autowired
	private ProductoServiceImpl service;
	
	/*@GetMapping
	public ResponseEntity<Page<Producto>> listar(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		Page<Producto> productos = service.listarPaginado(pageNo, pageSize);

		return new ResponseEntity<Page<Producto>>(productos, HttpStatus.OK);
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") int id) {
		Producto unaProducto = service.listarxID(id);
		if(unaProducto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Producto>(unaProducto,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar( @RequestBody Producto dato) {
		Producto unaProducto = service.listarxID(dato.getIdProduct());
		URI location = null;
		if(unaProducto != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaProducto.getIdProduct()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdProduct() + " --- " + location);
		} else {
			service.registrar(dato);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdProduct()).toUri();
		}		
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Producto> modificar( @RequestBody Producto dato) {		
		return new ResponseEntity<Producto>(service.modificar(dato),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
		Producto unaProducto = service.listarxID(id);
		if(unaProducto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<Page<ProductoFilter>> busquedaFiltrada(@RequestParam(required = false, value="categoria") String categoria,
																 @RequestParam(required = false, value="tipos") String[] tipos,
																 @RequestParam(required = false, value="etiquetas") String[] etiquetas,
																 @RequestParam(required = false, value="tallas") String[] tallas,
																 @RequestParam(required = false, value="marcas") String[] marcas,
																 @RequestParam(required = false, value="menorPrecio",defaultValue = "1") double menorPrecio,
																 @RequestParam(required = false, value="mayorPrecio",defaultValue = "99999") double mayorPrecio,
																 @RequestParam(defaultValue = "10") Integer cantidad,
																 @RequestParam(defaultValue = "0") Integer pagina) {

		return new ResponseEntity<>(service.busquedaFiltrada(categoria, tipos, etiquetas, tallas, marcas, menorPrecio, mayorPrecio, cantidad, pagina), HttpStatus.OK);
	}

}
