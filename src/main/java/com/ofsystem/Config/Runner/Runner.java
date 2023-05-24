package com.ofsystem.Config.Runner;

import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Model.Cliente.PaqueteProductos;
import com.ofsystem.Model.Cliente.TrazabilidadPedidos;
import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Model.Comprobante.Detalle;
import com.ofsystem.Model.Comprobante.TrazabilidadComprobantes;
import com.ofsystem.Model.Enums.*;
import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Enums.Name.*;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Producto.ProductoTallaColor;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Model.Usuario.Trabajador;
import com.ofsystem.Model.Usuario.Usuario;
import com.ofsystem.Service.Imple.Cliente.PaqueteProductosServiceImpl;
import com.ofsystem.Service.Imple.Cliente.PedidoServiceImpl;
import com.ofsystem.Service.Imple.Cliente.TrazabilidadPedidosServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.ComprobanteServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.DetalleServiceImpl;
import com.ofsystem.Service.Imple.Comprobante.TrazabilidadComprobantesServiceImpl;
import com.ofsystem.Service.Imple.Enums.*;
import com.ofsystem.Service.Imple.Producto.ProductoServiceImpl;
import com.ofsystem.Service.Imple.Producto.ProductoTallaColorServiceImpl;
import com.ofsystem.Service.Imple.Usuario.ClienteServiceImpl;
import com.ofsystem.Service.Imple.Usuario.TrabajadorServiceImpl;
import com.ofsystem.Service.Imple.Usuario.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Component
public class Runner implements CommandLineRunner {


    @Autowired
    private CategoriaServiceImpl categoriaService;
    @Autowired
    private ProductoServiceImpl productoService;
    @Autowired
    private TipoProductoServiceImpl tipoProductoService;
    @Autowired
    private TallaServiceImpl tallaService;
    @Autowired
    private EtiquetasServiceImpl etiquetaService;
    @Autowired
    private MarcaServiceImpl marcaService;
    @Autowired
    private ColorServiceImpl colorService;
    @Autowired
    private TipoPagoServiceImpl tipoPagoService;
    @Autowired
    private TipoDocServiceImpl tipoDocService;
    @Autowired
    private TipoComproServiceImpl tipoComproService;
    @Autowired
    private RolServiceImpl rolService;
    @Autowired
    private EstPedidoServiceImpl EstEnvioProductService;
    @Autowired
    private EstComproServiceImpl EstComproService;
    @Autowired
    private ProductoTallaColorServiceImpl productoTallaColorService;
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private ClienteServiceImpl clienteService;
    @Autowired
    private TrabajadorServiceImpl trabajadorService;
    @Autowired
    private PaqueteProductosServiceImpl paqueteProductosService;
    @Autowired
    private ComprobanteServiceImpl comprobanteService;
    @Autowired
    private DetalleServiceImpl detalleService;
    @Autowired
    private PedidoServiceImpl pedidoService;
    @Autowired
    private EstComproServiceImpl estComproService;
    @Autowired
    private EstPedidoServiceImpl estPedidoService;
    @Autowired
    private TrazabilidadComprobantesServiceImpl trazabilidadComprobantesService;
    @Autowired
    private TrazabilidadPedidosServiceImpl trazabilidadPedidosService;




    @Override
    public void run(String... args) throws Exception {

        //crear categorias
        try {
            for (CategoriaName nombreCategoria : CategoriaName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!categoriaService.existsByNombreCateg(nombreCategoria)) {
                    Categoria objeto = new Categoria(nombreCategoria);
                    categoriaService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear Tipo Productos
        try {
            for (TipoProductoName tipoProductoName : TipoProductoName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!tipoProductoService.existsByNombreTipoProduc(tipoProductoName)) {
                    TipoProducto objeto = new TipoProducto(tipoProductoName);
                    tipoProductoService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear Etiquetas
        try {
            for (EtiquetaName etiquetaName : EtiquetaName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!etiquetaService.existsByIdent(etiquetaName)) {
                    Etiquetas objeto = new Etiquetas(etiquetaName);
                    etiquetaService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear Tallas
        try {
            for (TallaName name : TallaName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!tallaService.existsByNombreTalla(name)) {
                    Talla objeto = new Talla(name);
                    tallaService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear Marcas
        try {
            for (MarcaName name : MarcaName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!marcaService.existsByIdent(name)) {
                    Marca objeto = new Marca(name);
                    marcaService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear Colores
        try {
            for (ColorName name : ColorName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!colorService.existsByIdentItem(name)) {
                    Color objeto = new Color(name);
                    colorService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear TipoPago
        try {
            for (TipoPagoName name : TipoPagoName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!tipoPagoService.existsByIdent(name)) {
                    TipoPago objeto = new TipoPago(name);
                    tipoPagoService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear TipoDoc
        try {
            for (TipoDocName name : TipoDocName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!tipoDocService.existsByNombreTipoDoc(name)) {
                    TipoDoc objeto = new TipoDoc(name);
                    tipoDocService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear TipoCompro
        try {
            for (TipoComproName name : TipoComproName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!tipoComproService.existsByIdent(name)) {
                    TipoCompro objeto = new TipoCompro(name);
                    tipoComproService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear Rol
        try {
            for (RolName name : RolName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!rolService.existsByIdent(name)) {
                    Rol objeto = new Rol(name);
                    rolService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear EstEnvioProduct
        try {
            for (EstPedidoName name : EstPedidoName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!EstEnvioProductService.existsByNombreCateg(name)) {
                    EstPedido objeto = new EstPedido(name);
                    EstEnvioProductService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //crear EstComproService
        try {
            for (EstComproName name : EstComproName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!EstComproService.existsByNombreCateg(name)) {
                    EstCompro objeto = new EstCompro(name);
                    EstComproService.registrar(objeto);
                }
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //producto temporal
        try {
            String nombreProducto = "Polo Manga Corta Hombre";
            //verificar si el producto ya existe
            if (!productoService.existsByNombre(nombreProducto)) {
                Producto unproducto = new Producto();
                unproducto.setDescripcionProduct("Tipo de cuello: Redondo | Modelo: WANNAWEB MAY21 | Estilo: Casual");
                unproducto.setNombreProduct(nombreProducto);
                unproducto.setPrecioUni(52.99);
                unproducto.setPrecioDescProduct(true);
                unproducto.setPrecioDescuProduct(40.56);
                unproducto.setExistente();
                unproducto.setIdMarca(marcaService.findByNombre(MarcaName.ETIQ_DOOAUSTRA));
                unproducto.setIdCateg(categoriaService.findByNombreCateg(CategoriaName.CABALLERO));
                unproducto.setIdTipoProduc(tipoProductoService.findByNombre(TipoProductoName.POLO));

                List<Etiquetas> etiquetas = new ArrayList<>();
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.TIPO_MANGA_CORTA));
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.ESTACION_VERANO));
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.ESTACION_PRIMAVERA));
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.MAT_ALGODON));
                unproducto.setIdEtiqueta(etiquetas);

                Talla tallas = tallaService.findByNombre(TallaName.LARGE);
                Color color = colorService.findByIdentItem(ColorName.COLOR_BLANCO);
                unproducto.setIUP();
                productoService.registrar(unproducto);
                productoTallaColorService.registrar(new ProductoTallaColor(unproducto,tallas,color,50));
            } else {
                // el producto ya existe
                System.out.println("El producto ya existe en la base de datos.");
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //Cliente temporal
        try {
            String nombreUsuario = "userCliente";
            if (!usuarioService.existsByUsername("userCliente")){
                //contra= 12345
                Usuario userCliente = new Usuario("userCliente","$2a$12$BClCi3YSMx1yFgcyO2kQuOrwl2L4J8uVPmjSPqM45V8hzVIS2jhfW",true,rolService.listarxID(3));
                usuarioService.registrar(userCliente);

                Cliente cliente = new Cliente();
                cliente.setNombre("Bryan Andrés");
                cliente.setApellido("Morán Vega");
                cliente.setFechaNac(new Date("24/08/2000"));
                cliente.setTelefono("994271287");
                cliente.setDireccion("Los Olivos");
                cliente.setUbigueo("150101");
                cliente.setNumDocumento("71850926");
                cliente.setCorreo("bryleo2009@hotmail.com");
                cliente.setIdUserCliente(usuarioService.findByUsername("userCliente"));
                clienteService.registrar(cliente);
            } else {
                System.out.println("El cliente ya existe en la base de datos.");
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //Trabajador temporal
        try {
            String nombreUsuario = "Online";
            if (!usuarioService.existsByUsername("Online")){
                //contra= 12345
                Usuario Online = new Usuario("Online","$2a$12$BClCi3YSMx1yFgcyO2kQuOrwl2L4J8uVPmjSPqM45V8hzVIS2jhfW",true,rolService.listarxID(2));
                usuarioService.registrar(Online);

                Trabajador trabajador = new Trabajador();
                trabajador.setNombre("Online");
                trabajador.setApellido("Online");
                trabajador.setCorreo("Online");
                trabajador.setFechaNac(new Date("24/08/2000"));
                trabajador.setTelefono("Online");
                trabajador.setDireccion("Online");
                trabajador.setUbigueo("Online");
                trabajador.setNumDocumento("Online");
                trabajador.setIdUserTrabajador(usuarioService.findByUsername("Online"));
                trabajador.setTrabajador(true);
                trabajadorService.registrar(trabajador);
            } else {
                System.out.println("El cliente ya existe en la base de datos.");
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //Paquieteria Producto
        try {
            //Pedido Producto
            List<PaqueteProductos> paqueteProductos =  new ArrayList<>();
            Date fecha = new Date();
            LocalDateTime localDateTime = fecha.toInstant().atZone(ZoneId.of("America/Lima")).toLocalDateTime();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            paqueteProductos.addAll(Arrays.asList(
                    new PaqueteProductos(productoService.listarxID(1),5,
                            clienteService.findByIdUserCliente_Username("userCliente"),
                            new Date(localDateTime.format(formato)))));
            paqueteProductosService.registroMasivo(paqueteProductos);
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //Comprobante, Detalle temporal y su Trazabilidad
        try {
            if (comprobanteService.listarxID("N0000") == null){

                //comprobante
                Comprobante comprobante = new Comprobante();
                comprobante.setIdComp("N0000");
                comprobante.setMontoSubtotalComp(100);
                comprobante.setMontoTotalComp(118);
                comprobante.setFechaEmiComp(new Date());
                comprobante.setDireccionComp("Lima");
                comprobante.setUbigeoComp("150101");
                comprobante.setIdTp(tipoPagoService.listarxID(1));
                comprobante.setIdTc(tipoComproService.listarxID(1));
                comprobante.setIdCliente(clienteService.findByIdUserCliente_Username("userCliente"));
                comprobante.setIuc();
                comprobanteService.registrar(comprobante);

                //detalle
                Date fecha = new Date();
                LocalDateTime localDateTime = fecha.toInstant().atZone(ZoneId.of("America/Lima")).toLocalDateTime();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                Detalle detalle = new Detalle();
                for(PaqueteProductos paqueteProducto : paqueteProductosService.findByIdClienteaAndAndFechaPedidoProduc(clienteService.findByIdUserCliente_Username("userCliente"),new Date(localDateTime.format(formato)))){
                    detalle.setCantProductDetalle(paqueteProducto.getCantProduct());
                    detalle.setPrecioUniDetalle(paqueteProducto.getProducto_id_product().getPrecioUni());
                    detalle.setPrecioTotalDetalle(detalle.getPrecioUniDetalle() * detalle.getCantProductDetalle());
                    detalle.setProductoDetalle(paqueteProducto.getProducto_id_product().getNombreProduct());
                    detalle.setIupProduct(paqueteProducto.getProducto_id_product().getIUP());
                    detalle.setImagen(paqueteProducto.getProducto_id_product().getImagen());
                    detalle.setPrecioDescuento(paqueteProducto.getProducto_id_product().getPrecioDescuProduct());
                    detalle.setIdComp(comprobanteService.listarxID("N0000"));
                    detalleService.registrar(detalle);
                }

                //trazabildiad
                TrazabilidadComprobantes trazabilidadComprobantes = new TrazabilidadComprobantes();
                trazabilidadComprobantes.setIdComp(comprobanteService.listarxID("N0000"));
                trazabilidadComprobantes.setIdProceActual(estComproService.listarxID(1));
                trazabilidadComprobantes.setFechaIniProc(new Date());
                trazabilidadComprobantes.setObservac("runner");
                trazabilidadComprobantes.setIdTraba(trabajadorService.findByIdUserCliente_Username("Online"));
                trazabilidadComprobantesService.registrar(trazabilidadComprobantes);
            } else {
                System.out.println("El comprobante ya existe en la base de datos.");
            }

        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }

        //Pedido temporal y su Trazabilidad
        try {
            if (pedidoService.findByIdComp_IdComp("N0000") == null){

                //Pedido
                Pedido pedido = new Pedido();
                Date fecha = new Date();
                LocalDateTime localDateTime = fecha.toInstant().atZone(ZoneId.of("America/Lima")).toLocalDateTime();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                Detalle detalle = new Detalle();
                pedido.setIdProduct(paqueteProductosService.findByIdClienteaAndAndFechaPedidoProduc(clienteService.findByIdUserCliente_Username("userCliente"),new Date(localDateTime.format(formato))));
                pedido.setFechaCompra(new Date());
                pedido.setNombreRecojo("Bryan Andrés");
                pedido.setApellidoRecojo("Morán Vega");
                pedido.setCelularRecojo("994271287");
                pedido.setCorreoRecojo("bryleo2009@hotmail.com");
                pedido.setCantidadCompra(pedido.cantidadTotal(pedido.getIdProduct()));
                pedido.setIdComp(comprobanteService.listarxID("N0000"));
                pedido.setDireccionRecojo("Lima");
                pedidoService.registrar(pedido);

                //trazabildiad
                TrazabilidadPedidos trazabilidadPedidos = new TrazabilidadPedidos();
                trazabilidadPedidos.setIdPedido(pedidoService.findByIdComp_IdComp("N0000"));
                trazabilidadPedidos.setIdProceActual(estPedidoService.listarxID(1));
                trazabilidadPedidos.setFechaIniProc(new Date());
                trazabilidadPedidos.setObservac("runner");
                trazabilidadPedidos.setIdTraba(trabajadorService.findByIdUserCliente_Username("Online"));
                trazabilidadPedidosService.registrar(trazabilidadPedidos);
            } else {
                System.out.println("El pedido ya existe en la base de datos.");
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }
    }
}
