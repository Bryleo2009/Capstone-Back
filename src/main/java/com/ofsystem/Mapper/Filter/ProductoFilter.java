package com.ofsystem.Mapper.Filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoFilter {
    public int id_product;
    public String iup;
    public String nombre_product;
    public String imagen;
    public double precio_uni;
    public boolean is_precio_desc_product;
    public Double precio_descu_product;
    public String etiquetas;
    public String tallas;
    public String marca;
    public String colores;
}
