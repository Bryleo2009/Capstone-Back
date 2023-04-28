package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Categoria;
import com.ofsystem.Model.Etiquetas;
import com.ofsystem.Model.Talla;
import com.ofsystem.Model.TipoProducto;
import jakarta.persistence.*;

import java.util.List;

public class ProductoFilter {
    public int id_product;
    public String nombre_product;
    public String imagen;
    public double precio_uni;
    public int stock_compro_product;
    public int stock_real_product;
    public boolean is_precio_desc_product;
    public Double precio_descu_product;
    public String etiquetas;
    public String tallas;
    public String marca;
}
