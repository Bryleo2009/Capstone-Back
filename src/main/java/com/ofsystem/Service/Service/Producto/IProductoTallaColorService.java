package com.ofsystem.Service.Service.Producto;

import com.ofsystem.Mapper.Filter.ColorTallaFilter;
import com.ofsystem.Model.Enums.Color;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Producto.ProductoTallaColor;
import com.ofsystem.Model.Enums.Talla;
import com.ofsystem.Service.Service.ICRUDService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductoTallaColorService extends ICRUDService<ProductoTallaColor, Integer> {

    ProductoTallaColor findByProductoAndTallaAndColor(Producto unProducto, Talla unaTalla, Color unColor);

    List<ColorTallaFilter> colorTalla(int idProduct);
}
