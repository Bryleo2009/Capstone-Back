package com.ofsystem.Capstone.Mapper.Filter;

import com.ofsystem.Capstone.Model.Enums.Color;
import com.ofsystem.Capstone.Model.Enums.Talla;
import com.ofsystem.Capstone.Model.Producto.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoFilter {
    Producto Producto;
    List<Talla> Tallas;
    List<Color> Colors;

    public com.ofsystem.Capstone.Model.Producto.Producto getProducto() {
        return Producto;
    }

    public void setProducto(com.ofsystem.Capstone.Model.Producto.Producto producto) {
        Producto = producto;
    }

    public List<Talla> getTallas() {
        return Tallas;
    }

    public void setTallas(List<Talla> tallas) {
        Tallas = tallas;
    }

    public List<Color> getColors() {
        return Colors;
    }

    public void setColors(List<Color> colors) {
        Colors = colors;
    }
}
