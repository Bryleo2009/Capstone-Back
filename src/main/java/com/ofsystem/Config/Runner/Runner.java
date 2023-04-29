package com.ofsystem.Config.Runner;

import com.ofsystem.Enums.*;
import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.*;
import com.ofsystem.Service.IRolService;
import com.ofsystem.Service.Imple.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    private EstEnvioProductServiceImpl EstEnvioProductService;

    @Autowired
    private EstComproServiceImpl EstComproService;


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
            for (EstEnvioProductName name : EstEnvioProductName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!EstEnvioProductService.existsByNombreCateg(name)) {
                    EstEnvioProduct objeto = new EstEnvioProduct(name);
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
                unproducto.setStockComproProduct(50);
                unproducto.setStockRealProduct(50);
                unproducto.setPrecioDescProduct(true);
                unproducto.setPrecioDescuProduct(40.56);
                unproducto.setIdMarca(marcaService.findByNombre(MarcaName.ETIQ_DOOAUSTRA));
                unproducto.setIdCateg(categoriaService.findByNombreCateg(CategoriaName.CABALLERO));
                unproducto.setIdTipoProduc(tipoProductoService.findByNombre(TipoProductoName.POLO));

                List<Etiquetas> etiquetas = new ArrayList<>();
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.TIPO_MANGA_CORTA));
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.ESTACION_VERANO));
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.ESTACION_PRIMAVERA));
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.MAT_ALGODON));
                unproducto.setIdEtiqueta(etiquetas);

                List<Talla> tallas = new ArrayList<>();
                tallas.add(tallaService.findByNombre(TallaName.LARGE));
                tallas.add(tallaService.findByNombre(TallaName.MEDIUM));
                tallas.add(tallaService.findByNombre(TallaName.EXTRA_LARGE));
                tallas.add(tallaService.findByNombre(TallaName.SMALL));
                unproducto.setIdTalla(tallas);

                List<Color> colores = new ArrayList<>();
                colores.add(colorService.findByIdentItem(ColorName.COLOR_HUESO));
                colores.add(colorService.findByIdentItem(ColorName.COLOR_BLANCO));
                unproducto.setIdColor(colores);

                productoService.registrar(unproducto);
            } else {
                // el producto ya existe
                System.out.println("El producto ya existe en la base de datos.");
            }
        } catch (Exception ex) {
            throw new ModeloNotFoundException(ex.getMessage().toString());
        }
    }



}
