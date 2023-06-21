package com.ofsystem.Capstone.Mapper;

import com.ofsystem.Capstone.Mapper.Filter.SeguimientoListadeseosFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IListadeseoMapper {

    @Select("SELECT  pe.id_listadeseo, pe.celular_recojo_listadeseo, pe.correo_recojo_listadeseo, pe.direccion_recojo_listadeseo, pe.nombre_recojo_listadeseo, com.id_comp FROM listadeseo pe\n" +
            "inner join comprobante com\n" +
            "on com.id_comp = pe.id_comp inner join cliente cl\n" +
            "on cl.id = com.id_cliente inner join usuario u\n" +
            "on u.id_user = cl.id_user_cliente where u.id_user = #{idUser};")

    List<SeguimientoListadeseosFilter>listarListaDeseo(@Param("idUser")int idUser);

}
