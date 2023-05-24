package com.ofsystem.Service.Service;

import com.ofsystem.Model.Enums.Color;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Producto.ProductoTallaColor;
import com.ofsystem.Model.Enums.Talla;

public interface IProductoTallaColorService extends ICRUDService<ProductoTallaColor, Integer>{

    ProductoTallaColor findByProductoAndTallaAndColor(Producto unProducto, Talla unaTalla, Color unColor);

}
