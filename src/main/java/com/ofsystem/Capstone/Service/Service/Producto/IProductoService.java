package com.ofsystem.Capstone.Service.Service.Producto;

import com.ofsystem.Capstone.Model.Producto.Producto;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

import java.util.List;

public interface IProductoService extends ICRUDService<Producto, Integer> {
    List<Producto> findProductoByIsExistenteIsTrue ();
}
