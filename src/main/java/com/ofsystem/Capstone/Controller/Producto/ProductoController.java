package com.ofsystem.Capstone.Controller.Producto;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.ofsystem.Capstone.Mapper.Filter.ProductoFilter;
import com.ofsystem.Capstone.Mapper.Filter.ProductoStorage;
import com.ofsystem.Capstone.Model.Producto.Producto;
import com.ofsystem.Capstone.Model.Producto.ProductoTallaColor;
import com.ofsystem.Capstone.Service.Imple.Enums.ColorServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Enums.TallaServiceImpl;
import com.ofsystem.Capstone.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Capstone.Mapper.Filter.RegistroProductFilter;
import com.ofsystem.Capstone.Mapper.Filter.TallaColorFilter;
import com.ofsystem.Capstone.Model.Enums.Color;
import com.ofsystem.Capstone.Model.Enums.Talla;
import com.ofsystem.Capstone.Service.Imple.Producto.ProductoServiceImpl;
import com.ofsystem.Capstone.Service.Imple.Producto.ProductoTallaColorServiceImpl;
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

		@GetMapping
		public ResponseEntity<List<ProductoFilter>> listar(
				@RequestParam(defaultValue = "0") Integer pageNo,
				@RequestParam(defaultValue = "10") Integer pageSize) {
			List<Producto> productos = service.findProductoByIsExistenteIsTrue();

			List<ProductoFilter> productoFilters = new ArrayList<>();

			for(Producto producto: productos){
				ProductoFilter productoTallaColors = new ProductoFilter();
				productoTallaColors.setTallas(servicePTC.talla(producto));
				productoTallaColors.setColors(servicePTC.colores(producto));
				productoTallaColors.setProducto(producto);
				productoFilters.add(productoTallaColors);
			}

			return new ResponseEntity<List<ProductoFilter>>(productoFilters, HttpStatus.OK);
		}

		@GetMapping("/listar")
		public ResponseEntity<List<Producto>> listar() {
			return new ResponseEntity<List<Producto>>(service.listar(),HttpStatus.OK);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Producto> listarPorId(@PathVariable("id") int id) {
			Producto unaProducto = service.listarxID(id);
			if(unaProducto == null) {

			}
			return new ResponseEntity<Producto>(unaProducto,HttpStatus.OK);
		}

		@GetMapping("/iup/{iup}")
		public ResponseEntity<List<Producto>> listarPorIup(@PathVariable("iup") String iup) {
			List<Producto> unaProducto = service.listarxIUP(iup);
			if(unaProducto == null) {
			}
			return new ResponseEntity<List<Producto>>(unaProducto,HttpStatus.OK);
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


	@PostMapping
		public ResponseEntity<Object> registrar( @RequestBody Producto dato) {
			dato.setIUP();
			return new ResponseEntity<>(service.registrar(dato), HttpStatus.OK);
		}

		@PostMapping("/filter")
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
			return new ResponseEntity<>(HttpStatus.OK);
		}

		@PutMapping
		public ResponseEntity<Producto> modificar( @RequestBody RegistroProductFilter registroProductFilter) throws IOException, WriterException{
			Producto dato = service.listarxID(registroProductFilter.getProducto().getIdProduct());
			dato.setIdProduct(registroProductFilter.getProducto().getIdProduct());
			dato.setDescripcionProduct(registroProductFilter.getProducto().getDescripcionProduct());
			dato.setNombreProduct(registroProductFilter.getProducto().getNombreProduct());
			dato.setPrecioUni(registroProductFilter.getProducto().getPrecioUni());
			dato.setPrecioDescuProduct(registroProductFilter.getProducto().getPrecioDescuProduct());
			dato.setImagen(registroProductFilter.getProducto().getImagen());
			dato.setIdCateg(registroProductFilter.getProducto().getIdCateg());
			dato.setIdMarca(registroProductFilter.getProducto().getIdMarca());
			dato.setIdTipoProduc(registroProductFilter.getProducto().getIdTipoProduc());
			dato.setIdEtiqueta(registroProductFilter.getProducto().getIdEtiqueta());
			dato.setIUP();
			generadorQR(registroProductFilter);

//		for (TallaColorFilter tallaColorFilter: registroProductFilter.getTallaColorFilters()){
//			Talla talla = serviceTalla.listarxID(tallaColorFilter.getTalla());
//			Color color = serviceColor.listarxID(tallaColorFilter.getColor());
//			ProductoTallaColor productoTallaColor = servicePTC.findByProducto_IdProductAndColorAndTalla(dato.getIdProduct(), talla)
//		}

			service.modificar(dato);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
			Producto unaProducto = service.listarxID(id);
			unaProducto.setExistente(false);
			service.modificar(unaProducto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}

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
	@PutMapping("/carrito")
	public ResponseEntity<Object> CarritoOperador( @RequestBody List<ProductoFilter> dato) {

		for (ProductoFilter productoStorage : dato) {
			for(int i = 0; i > productoStorage.getTallas().size(); i++){
				Producto unproducto = service.listarxID(productoStorage.getProducto().getIdProduct());
				Talla unatalla = serviceTalla.listarxID(productoStorage.getTallas().get(i).getIdTalla());
				Color uncolor = serviceColor.listarxID(productoStorage.getColors().get(i).getIdColor());
				ProductoTallaColor productoTallaColor = servicePTC.findByProductoAndTallaAndColor(unproducto,unatalla,uncolor);

				if (productoTallaColor != null) {
					if (productoTallaColor.getStockVirtualProduct() >= cantidad && (productoTallaColor.getTalla().getIdTalla()==talla) && (productoTallaColor.getColor().getIdColor()==color)) {
						productoTallaColor.setStockVirtualProduct(productoTallaColor.getStockVirtualProduct() - cantidad);
						productoTallaColor.setIdProductoTallaColor(productoTallaColor.getIdProductoTallaColor());
						productoTallaColorService.modificar(productoTallaColor);
					}
				}
			}



		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	}
