package com.ofsystem.Mapper;


import com.ofsystem.Mapper.Filter.SeguimientoPedidoFilter;
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
}
