package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Categoria;
import com.ofsystem.Model.Etiquetas;
import com.ofsystem.Model.Talla;
import com.ofsystem.Model.TipoProducto;
import jakarta.persistence.*;

import java.util.List;

public class ProductoFilter {
    public int id_product;
    public String descripcion_product;
    public String nombre_product;
    public double precio_uni;
    public int stock_product;
    public boolean is_precio_desc_product;
    public Double precio_descu_product;
    public String imagen;
    public Categoria id_categ;
    public TipoProducto id_tipo_produc;

    public List<Etiquetas> idEtiqueta;

    public List<Talla> idTalla;
}
