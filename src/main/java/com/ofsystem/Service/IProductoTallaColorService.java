package com.ofsystem.Service;

import com.ofsystem.Model.Color;
import com.ofsystem.Model.Producto;
import com.ofsystem.Model.ProductoTallaColor;
import com.ofsystem.Model.Talla;

public interface IProductoTallaColorService extends ICRUDService<ProductoTallaColor, Integer>{

    ProductoTallaColor findByProductoAndTallaAndColor(Producto unProducto, Talla unaTalla, Color unColor);

}
