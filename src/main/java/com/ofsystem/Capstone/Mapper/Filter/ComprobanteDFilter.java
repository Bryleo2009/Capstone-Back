package com.ofsystem.Capstone.Mapper.Filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComprobanteDFilter {
    public String id_comp;
    public String direccion_comp;
    public Timestamp fecha_emi_comp;
    public String iuc ;
    public Double monto_subtotal_comp;
    public Double monto_total_comp;
    public String razon_social_comp;
    public String ruc_comp;
    public String ubigeo_comp;
    public int id_cliente;
    public int id_tc;
    public int id_tp;

    public String apellido;
    public String correo_cliente;
    public String nombre;
    public String direccion_cliente;
    public String num_documento;
    public String telefono;
    public String ubigueo_cliente;

     public int cant_product_detalle;
    public Double   precio_descuento_detalle;
    public Double   precio_total_detalle;
    public Double   precio_uni_detalle;
       public String     producto_detalle;

}
