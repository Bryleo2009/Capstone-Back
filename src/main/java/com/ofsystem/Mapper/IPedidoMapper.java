package com.ofsystem.Mapper;


import com.ofsystem.Mapper.Filter.ColorTallaFilter;
import com.ofsystem.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Mapper.Filter.TrazabilidadPedidoFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IPedidoMapper {
        @Select("SELECT  pe.id_pedido, pe.celular_recojo_pedido, pe.correo_recojo_pedido, pe.direccion_recojo_pedido, pe.nombre_recojo_pedido, com.id_comp FROM pedido pe\n" +
                "inner join comprobante com\n" +
                "on com.id_comp = pe.id_comp inner join cliente cl\n" +
                "on cl.id = com.id_cliente inner join usuario u\n" +
                "on u.id_user = cl.id_user_cliente where u.id_user = #{idUser};")
    List<SeguimientoPedidoFilter>listarPedido(@Param("idUser")int idUser);

        @Select("SELECT  trazape.fecha_fin_proc,trazape.fecha_ini_proc,estpro.vista_item, pe.id_pedido FROM pedido pe\n" +
                "inner join traza_pedidos trazape\n" +
                "on trazape.id_pedido = pe.id_pedido\n" +
                "inner join est_product estpro\n" +
                "on estpro.id_est_pedido = trazape.id_proce_actual\n" +
                "where pe.id_pedido = #{idPedido};")
        List<TrazabilidadPedidoFilter>TrazaPedido(@Param("idPedido") int idPedido);


}
