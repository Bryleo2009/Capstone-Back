package com.ofsystem.Config.Runner;

import com.ofsystem.Enums.*;
import com.ofsystem.Config.Exception.ModeloNotFoundException;
import com.ofsystem.Model.*;
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

    @Override
    public void run(String... args) throws Exception {

        //crear categorias
        try {
            for (CategoriaName nombreCategoria : CategoriaName.values()) {
                // El enum ya está registrado en la base de datos, no se vuelve a registrar
                if (!categoriaService.existsByNombreCateg(nombreCategoria)) {
                    Categoria categoria = new Categoria(nombreCategoria);
                    categoriaService.registrar(categoria);
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
                    TipoProducto tipoProducto = new TipoProducto(tipoProductoName);
                    tipoProductoService.registrar(tipoProducto);
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
                    Etiquetas etiquetas = new Etiquetas(etiquetaName);
                    etiquetaService.registrar(etiquetas);
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
                    Marca etiquetas = new Marca(name);
                    marcaService.registrar(etiquetas);
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
                    Color etiquetas = new Color(name);
                    colorService.registrar(etiquetas);
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
