package com.ofsystem.Capstone.Mapper;

import com.ofsystem.Capstone.Mapper.Filter.TallaFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ITallaMapper {
    @Select("select t.* from producto_talla_color ptc\n" +
            "inner join talla t ON t.id_talla = ptc.id_talla_id_talla\n" +
            "where ptc.stock_virtual_product > 0 and ptc.existe_noexiste = true and ptc.producto_id_product = #{id} group by t.id_talla, t.abrevi_item, t.ident_item, t.vista_item;")
    List<TallaFilter> listarTallasxID(@Param("id") int id);


}
