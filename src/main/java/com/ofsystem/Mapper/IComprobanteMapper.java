package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.ComprobanteDFilter;
import com.ofsystem.Mapper.Filter.ComprobanteFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface IComprobanteMapper {

    @Select("SELECT e.id_comp, e.direccion_comp, e.fecha_emi_comp, e.iuc, e.monto_subtotal_comp, e.monto_total_comp, e.razon_social_comp, e.ruc_comp, e.ubigeo_comp, e.id_cliente, e.id_tc, e.id_tp,\n" +
            "c.apellido,c.correo_cliente,c.nombre, c.direccion_cliente, c.num_documento, c.telefono, c.ubigueo_cliente,\n" +
            "d.cant_product_detalle, d.precio_descuento_detalle, d.precio_total_detalle, d.precio_uni_detalle, d.producto_detalle\n" +
            "from  public.comprobante e\n" +
            "left join public.cliente c on e.id_cliente = c.id\n" +
            "left join public.detalle_comprobante d on d.id_comp = e.id_comp where d.id_comp = #{idComp};")
    List<ComprobanteDFilter> ListarComprobanteXID(@Param("idComp") String idComp);
}
