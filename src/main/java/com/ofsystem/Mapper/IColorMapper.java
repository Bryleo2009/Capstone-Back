package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.ColorFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IColorMapper {
    @Select("SELECT abrevi_item, nombre_item, vista_item\n" +
            "\tFROM public.color\n" +
            "\twhere ident_item like '%COLOR%';")
    List<ColorFilter> getColor();

    @Select("select c.* from producto_talla_color ptc\n" +
            "inner join color c ON c.id_color = ptc.id_color_id_color\n" +
            "where ptc.stock_virtual_product > 0 and ptc.existe_noexiste = true and ptc.producto_id_product =  #{id} group by c.id_color, c.abrevi_item, c.ident_item, c.vista_item;")
    List<ColorFilter> listarColoresxID(@Param("id") int id);
}
