package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.EtiquetaFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IEtiquetaMapper {
    @Select("SELECT abrevi_item, nombre_item, vista_item\n" +
            "\tFROM public.etiquetas\n" +
            "\twhere ident_item like '%COLOR%';")
    List<EtiquetaFilter> getColor();
}
