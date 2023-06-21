package com.ofsystem.Capstone.Service.Service.Producto;

import com.ofsystem.Capstone.Model.Enums.Color;
import com.ofsystem.Capstone.Model.Producto.Producto;
import com.ofsystem.Capstone.Model.Producto.ProductoTallaColor;
import com.ofsystem.Capstone.Model.Enums.Talla;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

import java.util.List;

public interface IProductoTallaColorService extends ICRUDService<ProductoTallaColor, Integer> {

    List<Talla> talla(Producto unProducto);

    List<Color> colores(Producto unProducto);

    ProductoTallaColor findByProducto_IdProductAndColorAndTalla(int idProducto, Color color, Talla talla);
}
