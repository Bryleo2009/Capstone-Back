package com.ofsystem.Controller;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.ProductoFilter;
import com.ofsystem.Model.Producto;
import com.ofsystem.Service.Imple.ProductoServiceImpl;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
@RequestMapping("/Productos")
public class ProductoController {
	@Value("${media.location}")
	private String mediaLocation;

	public Path rootLocation;

	@Autowired
	private ProductoServiceImpl service;

	String IUP="";
	
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
	public ResponseEntity<Object> registrar( @RequestBody Producto dato) throws IOException {
		dato.setIUP();
		IUP = dato.getIUP();
		String cadena = IUP;
		String subcadena = cadena.substring(0, cadena.length()-8);
		Producto unaProducto = service.listarxIUP(subcadena);
		URI location = null;
		if(unaProducto != null) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaProducto.getIdProduct()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdProduct() + " --- " + location);
		} else {
			service.registrar(dato);
			generadorQR(dato);
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
																 @RequestParam(required = false, value="colores") String[] colores,
																 @RequestParam(required = false, value="menorPrecio",defaultValue = "1") double menorPrecio,
																 @RequestParam(required = false, value="mayorPrecio",defaultValue = "99999") double mayorPrecio,
																 @RequestParam(defaultValue = "10") Integer cantidad,
																 @RequestParam(defaultValue = "0") Integer pagina) {
		System.out.println("****de FROM*****");
		System.out.println("tipos '"+String.join("', '", tipos)+"'");
		System.out.println("etiquetas '"+String.join("', '", etiquetas)+"'");
		System.out.println("tallas '"+String.join("', '", tallas)+"'");
		System.out.println("marcas '"+String.join("', '", marcas)+"'");
		System.out.println("colores '"+String.join("', '", colores)+"'");
		return new ResponseEntity<>(service.busquedaFiltrada(categoria, tipos, etiquetas, tallas, marcas, colores,menorPrecio, mayorPrecio, cantidad, pagina), HttpStatus.OK);
	}

	public void generadorQR(Producto producto) throws IOException {

		//producto.setIUP();
		// Generar el código QR con el dato IUP
		String iup = IUP;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		QRCode.from(iup).to(ImageType.PNG).withSize(550, 550).writeTo(baos);

		// Crear el directorio si no existe
		rootLocation = Paths.get(mediaLocation);
		Path productosQr = rootLocation.resolve("productosQr");
		if (!Files.exists(productosQr)) {
			Files.createDirectories(productosQr);
		}

		// Crear el archivo con el nombre del IUP
		Path qrFile = productosQr.resolve(iup + ".png");
		Files.write(qrFile, baos.toByteArray());

		// Obtener la ruta absoluta del archivo guardado
		String rutaArchivo = qrFile.toAbsolutePath().toString();

		System.out.println("Qr generado: IUP|"+IUP+" - Ruta|"+rutaArchivo);
	}




}
