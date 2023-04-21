package com.ofsystem.Config.Runner;

import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Exception.ModeloNotFoundException;
import com.ofsystem.Model.Categoria;
import com.ofsystem.Model.TipoProducto;
import com.ofsystem.Service.Imple.CategoriaServiceImpl;
import com.ofsystem.Service.Imple.TipoProductoServiceImpl;
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
    private TipoProductoServiceImpl tipoProductoService;

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
    }
}
