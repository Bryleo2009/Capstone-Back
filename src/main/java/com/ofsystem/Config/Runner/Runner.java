package com.ofsystem.Config.Runner;

import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TallaName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Exception.ModeloNotFoundException;
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

        //producto temporal
        try {
            String nombreProducto = "camisa Negra";
            //verificar si el producto ya existe
            if (!productoService.existsByNombre(nombreProducto)) {
                Producto unproducto = new Producto();
                unproducto.setDescripcionProduct("camisa negra de gran tamaño");
                unproducto.setNombreProduct(nombreProducto);
                unproducto.setPrecioUni(15.99);
                unproducto.setStockProduct(50);
                unproducto.setPrecioDescProduct(true);
                unproducto.setPrecioDescuProduct(4.2);
                unproducto.setIdCateg(categoriaService.findByNombreCateg(CategoriaName.CABALLERO));
                unproducto.setIdTipoProduc(tipoProductoService.findByNombre(TipoProductoName.CAMISA));

                List<Etiquetas> etiquetas = new ArrayList<>();
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.COLOR_AZUL));
                etiquetas.add(etiquetaService.findByNombre(EtiquetaName.MANGA_LARGA));
                unproducto.setIdEtiqueta(etiquetas);

                List<Talla> tallas = new ArrayList<>();
                tallas.add(tallaService.findByNombre(TallaName.LARGE));
                tallas.add(tallaService.findByNombre(TallaName.SMOLL));
                unproducto.setIdTalla(tallas);

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
