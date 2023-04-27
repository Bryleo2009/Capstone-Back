package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.ProductoFilter;
import com.ofsystem.Model.Producto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IProductoMapper {
    @Select("select p.*  from public.producto p;")
    ProductoFilter busquedaFiltrada ();
}
