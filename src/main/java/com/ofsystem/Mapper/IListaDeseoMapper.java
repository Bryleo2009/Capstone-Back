package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.ListadeseoFilter;
import com.ofsystem.Mapper.Filter.ProductoFilter;
import com.ofsystem.Mapper.Filter.TallaFilter;
import com.ofsystem.Mapper.Filter.TrazabilidadPedidoFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;



@Mapper
public interface IListaDeseoMapper {

   @Select("SELECT ld.id_lista_deseo, ld.fecha_lista_deseo,p.id_product, p.nombre_product, p.imagen,\n" +
           "c.id, c.apellido\n" +
           "FROM listadeseo ld \n" +
           "left JOIN producto p ON ld.id_product = p.id_product\n" +
           "left JOIN cliente c ON ld.id_lista_deseo = c.id\n" +
           "WHERE ld.id_lista_deseo = #{id_lista_deseo};")

   List<ListadeseoFilter> listarListadeseos(@Param("id_lista_deseo")int id_lista_deseo);

}
