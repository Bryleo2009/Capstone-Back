package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.ColorFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IColorMapper {
    @Select("SELECT abrevi_item, nombre_item, vista_item\n" +
            "\tFROM public.color\n" +
            "\twhere ident_item like '%COLOR%';")
    List<ColorFilter> getColor();
}
