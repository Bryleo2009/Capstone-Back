package com.ofsystem.Controller;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Mapper.Filter.CarritoFilter;
import com.ofsystem.Mapper.Filter.ProductoFilter;
import com.ofsystem.Mapper.Filter.RegistroProductFilter;
import com.ofsystem.Mapper.Filter.TallaColorFilter;
import com.ofsystem.Model.Producto;
import com.ofsystem.Model.ProductoTallaColor;
import com.ofsystem.Model.Talla;
import com.ofsystem.Service.Imple.ColorServiceImpl;
import com.ofsystem.Service.Imple.ProductoServiceImpl;
import com.ofsystem.Service.Imple.ProductoTallaColorServiceImpl;
import com.ofsystem.Service.Imple.TallaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Productos")
public class ProductoController {
	@Value("${media.location}")
	private String mediaLocation;

	public Path rootLocation;

	@Autowired
	private ProductoServiceImpl service;

	@Autowired
	private ProductoTallaColorServiceImpl servicePTC;

	@Autowired
	private TallaServiceImpl serviceTalla;

	@Autowired
	private ColorServiceImpl serviceColor;

	String IUP="";
	
	/*@GetMapping
	public ResponseEntity<Page<Producto>> listar(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		Page<Producto> productos = service.listarPaginado(pageNo, pageSize);

		return new ResponseEntity<Page<Producto>>(productos, HttpStatus.OK);
	}*/

	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listar() {
		return new ResponseEntity<List<Producto>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") int id) {
		Producto unaProducto = service.listarxID(id);
		if(unaProducto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}		
		return new ResponseEntity<Producto>(unaProducto,HttpStatus.OK);
	}

	@GetMapping("/iup/{iup}")
	public ResponseEntity<List<Producto>> listarPorIup(@PathVariable("iup") String iup) {
		List<Producto> unaProducto = service.listarxIUP(iup);
		if(unaProducto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + iup);
		}
		return new ResponseEntity<List<Producto>>(unaProducto,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody RegistroProductFilter registroProductFilter) throws IOException, WriterException {
		Producto dato = registroProductFilter.getProducto();
		List<TallaColorFilter> tallaColorFilters = registroProductFilter.getTallaColorFilters();
		dato.setIUP();
		dato.setExistente();
		IUP = dato.getIUP();
		String cadena = IUP;
		int unaProducto = service.listarxIUP(cadena).size();
		URI location = null;
		if(unaProducto != 0) {
			//location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaProducto.getIdProduct()).toUri();
			throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdProduct() + " --- " + location);
		} else {
			service.registrar(dato);
			registroProductFilter.setProducto(dato);
			generadorQR(registroProductFilter);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdProduct()).toUri();

			for (TallaColorFilter tallaColorFilter: tallaColorFilters){
				ProductoTallaColor productoTallaColor = new ProductoTallaColor( dato,
						serviceTalla.listarxID(tallaColorFilter.getTalla()),
						serviceColor.listarxID(tallaColorFilter.getColor()),
						tallaColorFilter.getCantidad());

				servicePTC.registrar(productoTallaColor);
			}
		}
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/masivo")
	public ResponseEntity<Object> registrarMasivo(@RequestBody List<RegistroProductFilter> registroProductFilter) throws IOException, WriterException {
		for(RegistroProductFilter registros: registroProductFilter){
			Producto dato = registros.getProducto();
			List<TallaColorFilter> tallaColorFilters = registros.getTallaColorFilters();
			dato.setIUP();
			dato.setExistente();
			IUP = dato.getIUP();
			String cadena = IUP;
			int unaProducto = service.listarxIUP(cadena).size();
			URI location = null;
			if(unaProducto != 0) {
				//location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unaProducto.getIdProduct()).toUri();
				//throw new ModeloNotFoundException("ID YA REGISTRADO: " + dato.getIdProduct() + " --- " + location);
				System.out.println("Producto no registrado por existencia similar: " + dato.getIUP());
			} else {
				service.registrar(dato);
				registros.setProducto(dato);
				generadorQR(registros);
				location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dato.getIdProduct()).toUri();

				for (TallaColorFilter tallaColorFilter: tallaColorFilters){
					ProductoTallaColor productoTallaColor = new ProductoTallaColor( dato,
							serviceTalla.listarxID(tallaColorFilter.getTalla()),
							serviceColor.listarxID(tallaColorFilter.getColor()),
							tallaColorFilter.getCantidad());

					servicePTC.registrar(productoTallaColor);
				}
			}
		}
		return new ResponseEntity<>(HttpStatus.OK);
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
		System.out.println("categoria '"+categoria+"'");
		System.out.println("tipos '"+String.join("', '", tipos)+"'");
		System.out.println("etiquetas '"+String.join("', '", etiquetas)+"'");
		System.out.println("tallas '"+String.join("', '", tallas)+"'");
		System.out.println("marcas '"+String.join("', '", marcas)+"'");
		System.out.println("colores '"+String.join("', '", colores)+"'");
		System.out.println("cantidad '"+cantidad+"'");
		System.out.println("página '"+pagina+"'");
		return new ResponseEntity<>(service.busquedaFiltrada(categoria, tipos, etiquetas, tallas, marcas, colores,menorPrecio, mayorPrecio, cantidad, pagina), HttpStatus.OK);
	}

	@GetMapping("/random")
	public ResponseEntity<List<ProductoFilter>> randomProduct (@RequestParam(required = true, value="categoria") String categoria,
															   @RequestParam(defaultValue = "10") Integer cantidad){
		return new ResponseEntity<>(service.randomProduct(cantidad,categoria),HttpStatus.OK);
	}

	/*public void generadorQR(Producto producto) throws IOException {

		//producto.setIUP();
		// Generar el código QR con el dato IUP
		String iup = IUP;
		String contenidoQR = 	"IUP: " + producto.getIUP() + "\n" +
								"Nombre: " + producto.getNombreProduct() + "\n" +
								"Precio: " + producto.getPrecioUni() + "\n" +
								"Descripción: " + producto.getDescripcionProduct() + "\n" +
								"Categorias: " + producto.getIdCateg() + "\n" +
								"Marcas: " + producto.getIdMarca().getVistaItem() + "\n" +
								"Etiquetas: " + producto.concatenarEtiqueta(producto.getIdEtiqueta()) + "\n" +
								"Tallas: " + producto.concatenarTalla(producto.getIdTalla()) + "\n" +
								"Colores: " + producto.concatenarColor(producto.getIdColor()) ;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		QRCode.from(contenidoQR).to(ImageType.PNG).withSize(550, 550).writeTo(baos);

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
	}*/


	public void generadorQR(RegistroProductFilter producto) throws IOException, WriterException {
		//producto.setIUP();
		// Generar el código QR con el dato IUP
		String iup = IUP;
		// Generar el código QR con los datos del producto en formato JSON
		Gson gson = new Gson();
		String productoJson = gson.toJson(producto);
		MultiFormatWriter writer = new MultiFormatWriter();
		BitMatrix bitMatrix = writer.encode(productoJson, BarcodeFormat.QR_CODE, 550, 550);

		// Crear el directorio si no existe
		rootLocation = Paths.get(mediaLocation);
		Path productosQr = rootLocation.resolve("productosQr");
		if (!Files.exists(productosQr)) {
			Files.createDirectories(productosQr);
		}

		// Crear el archivo con el nombre del IUP
		Path qrFile = productosQr.resolve(iup + ".png");
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", qrFile);

		// Obtener la ruta absoluta del archivo guardado
		String rutaArchivo = qrFile.toAbsolutePath().toString();
		String nombreArchivo = rutaArchivo.substring(rutaArchivo.lastIndexOf(File.separator) + 1);

		String rutaCompleta = "http://localhost:9090/media/productosQr/" + nombreArchivo;


		System.out.println("Qr generado: IUP|"+IUP+" - Ruta| "+rutaCompleta);
	}



}
