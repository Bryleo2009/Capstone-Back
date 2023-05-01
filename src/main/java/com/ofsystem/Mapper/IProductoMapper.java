package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.ProductoFilter;
import com.ofsystem.Model.Producto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IProductoMapper {
       @Select("select p.id_product, p.nombre_product, p.stock_compro_product, p.stock_real_product, p.imagen, p.precio_uni,\n" +
               "p.is_precio_desc_product, p.precio_descu_product, m.vista_item as marca,\n" +
               "string_agg(distinct (e.vista_item), ', ') as etiquetas, string_agg(distinct (t.vista_item), ', ') as tallas from public.producto p\n" +
               "inner join public.categoria_product ct ON ct.id_categ = p.id_categ\n" +
               "inner join public.tipo_producto tp on tp.id_tipo_produc = p.id_tipo_produc\n" +
               "inner join public.producto_id_etiqueta ON producto_id_etiqueta.producto_id_product = p.id_product\n" +
               "inner join public.etiquetas e ON e.id_etiqueta = producto_id_etiqueta.id_etiqueta_id_etiqueta\n" +
               "inner join public.producto_id_talla ON producto_id_talla.producto_id_product = p.id_product\n" +
               "inner join public.talla t ON t.id_talla = producto_id_talla.id_talla_id_talla\n" +
               "inner join public.marcas m ON m.id_marca = p.id_marca\n" +
               "inner join public.producto_id_color ON producto_id_color.producto_id_product = p.id_product\n" +
               "inner join public.colores c ON c.id_color = producto_id_color.id_color_id_color\n" +
               "where (ct.abrevi_item = ${categoria}  OR COALESCE(${categoria}, '') = '')\n" +
               "AND (tp.abrevi_item IN ( ${tipos} ) OR COALESCE(${tipos}, '') = '')\n" +
               "AND (e.abrevi_item IN ( ${etiquetas} ) OR COALESCE(${etiquetas}, '') = '')\n" +
               "AND (t.abrevi_item IN ( ${tallas} ) OR COALESCE(${tallas}, '') = '')\n" +
               "AND (m.abrevi_item IN ( ${marcas} ) OR COALESCE( ${marcas}, '') = '')\n" +
               "AND (c.abrevi_item IN ( ${colores} ) OR COALESCE( ${colores}, '') = '')\n" +
               "AND ((p.is_precio_desc_product AND p.precio_descu_product BETWEEN ${menorPrecio} AND ${mayorPrecio}) OR\n" +
               "(NOT p.is_precio_desc_product AND p.precio_uni BETWEEN ${menorPrecio} AND ${mayorPrecio}))\n" +
               "group by p.id_product, m.vista_item\n" +
               "order by p.id_product LIMIT ${cantidad} OFFSET ${pagina};")
    List<ProductoFilter> busquedaFiltrada (@Param("categoria") String categoria,
                                           @Param("tipos") String tipos,
                                           @Param("etiquetas") String etiquetas,
                                           @Param("tallas") String tallas,
                                           @Param("marcas") String marcas,
                                           @Param("colores") String colores,
                                           @Param("menorPrecio") double menorPrecio,
                                           @Param("mayorPrecio") double mayorPrecio,
                                           @Param("cantidad") int cantidad,
                                           @Param("pagina") int pagina);

    @Select("SELECT * FROM producto WHERE iup LIKE '%${iup}%'")
    Producto listarxIUP(@Param("iup") String iup);

}
