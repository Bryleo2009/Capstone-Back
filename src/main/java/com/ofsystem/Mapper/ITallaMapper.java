package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.TallaFilter;
import com.ofsystem.Model.Talla;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ITallaMapper {
    @Select("SELECT abrevi_item, nombre_item, vista_item FROM public.producto_id_talla\n" +
            "inner join public.talla t ON t.id_talla = producto_id_talla.id_talla_id_talla\n" +
            ";")
    List<Talla> listarTallasxID(@Param("id") int id);
}
