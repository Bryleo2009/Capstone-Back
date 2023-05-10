package com.ofsystem.Mapper;

import com.ofsystem.Mapper.Filter.ProductoFilter;
import com.ofsystem.Model.Producto;
import com.ofsystem.Model.Talla;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IProductoMapper {
       @Select("SELECT \n" +
               "    p.id_product, \n" +
               "\tp.iup, \n" +
               "    p.nombre_product, \n" +
               "    p.imagen, \n" +
               "    p.precio_uni,\n" +
               "    p.is_precio_desc_product, \n" +
               "    p.precio_descu_product, \n" +
               "    m.vista_item as marca,\t\n" +
               "    string_agg(DISTINCT e.vista_item, ', ') as etiquetas, \n" +
               "    string_agg(DISTINCT t.vista_item, ', ') as tallas, \n" +
               "    string_agg(DISTINCT c.vista_item, ', ') as colores\n" +
               "FROM public.producto p\n" +
               "INNER JOIN public.categoria_product ct ON ct.id_categ = p.id_categ\n" +
               "INNER JOIN public.tipo_producto tp ON tp.id_tipo_produc = p.id_tipo_produc\n" +
               "INNER JOIN public.producto_id_etiqueta ON producto_id_etiqueta.producto_id_product = p.id_product\n" +
               "INNER JOIN public.etiquetas e ON e.id_etiqueta = producto_id_etiqueta.id_etiqueta_id_etiqueta\n" +
               "INNER JOIN public.producto_talla_color ptc ON ptc.producto_id_product = p.id_product\n" +
               "INNER JOIN public.talla t ON t.id_talla = ptc.id_talla_id_talla\n" +
               "INNER JOIN public.color c ON c.id_color = ptc.id_color_id_color\n" +
               "INNER JOIN public.marcas m ON m.id_marca = p.id_marca\n" +
               "WHERE \n" +
               "    (ct.abrevi_item = ${categoria}  OR COALESCE(${categoria} , '') = '')\n" +
               "AND (tp.abrevi_item IN ( ${tipos} ) OR COALESCE(${tipos}, '') = '')\n" +
               "AND (e.abrevi_item IN ( ${etiquetas} ) OR COALESCE(${etiquetas}, '') = '')\n" +
               "AND (c.abrevi_item IN ( ${colores} ) OR COALESCE(${colores}, '') = '')\n" +
               "AND (t.abrevi_item IN ( ${tallas} ) OR COALESCE(${tallas}, '') = '')\n" +
               "AND (m.abrevi_item IN ( ${marcas} ) OR COALESCE(${marcas}, '') = '')\n" +
               "AND ((p.is_precio_desc_product AND p.precio_descu_product BETWEEN ${menorPrecio} AND ${mayorPrecio}) OR\n" +
               "(NOT p.is_precio_desc_product AND p.precio_uni BETWEEN ${menorPrecio} AND ${mayorPrecio}))\n" +
               "AND p.is_existente = true\n" +
               "GROUP BY p.id_product, m.vista_item\n" +
               "HAVING (\n" +
               "\tSELECT SUM(stock_real_product) FROM public.producto_talla_color\n" +
               "\tinner join public.talla t ON t.id_talla = producto_talla_color.id_talla_id_talla\n" +
               "\tinner join public.color c ON c.id_color = producto_talla_color.id_color_id_color\n" +
               "\twhere \n" +
               "\t\t(t.abrevi_item IN ( ${tallas} ) OR COALESCE(${tallas}, '') = '')\n" +
               "\tAND (c.abrevi_item IN ( ${colores} ) OR COALESCE(${colores}, '') = '')\n" +
               "\tAND producto_id_product = p.id_product\n" +
               ") > 0\n" +
               "ORDER BY p.id_product LIMIT ${cantidad} OFFSET ${pagina} * ${cantidad};")
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

       @Select("SELECT \n" +
               "    p.id_product, \n" +
               "\tp.iup, \n" +
               "    p.nombre_product, \n" +
               "    p.imagen, \n" +
               "    p.precio_uni,\n" +
               "    p.is_precio_desc_product, \n" +
               "    p.precio_descu_product, \n" +
               "    m.vista_item as marca,\t\n" +
               "    string_agg(DISTINCT e.vista_item, ', ') as etiquetas, \n" +
               "    string_agg(DISTINCT t.vista_item, ', ') as tallas, \n" +
               "    string_agg(DISTINCT c.vista_item, ', ') as colores\n" +
               "FROM public.producto p\n" +
               "INNER JOIN public.categoria_product ct ON ct.id_categ = p.id_categ\n" +
               "INNER JOIN public.tipo_producto tp ON tp.id_tipo_produc = p.id_tipo_produc\n" +
               "INNER JOIN public.producto_id_etiqueta ON producto_id_etiqueta.producto_id_product = p.id_product\n" +
               "INNER JOIN public.etiquetas e ON e.id_etiqueta = producto_id_etiqueta.id_etiqueta_id_etiqueta\n" +
               "INNER JOIN public.producto_talla_color ptc ON ptc.producto_id_product = p.id_product\n" +
               "INNER JOIN public.talla t ON t.id_talla = ptc.id_talla_id_talla\n" +
               "INNER JOIN public.color c ON c.id_color = ptc.id_color_id_color\n" +
               "INNER JOIN public.marcas m ON m.id_marca = p.id_marca\n" +
               "WHERE (ct.abrevi_item = #{categoria}  OR COALESCE(#{categoria} , '') = '')\n" +
               "AND ((p.is_precio_desc_product AND p.precio_descu_product BETWEEN 1 AND 1000) OR\n" +
               "(NOT p.is_precio_desc_product AND p.precio_uni BETWEEN 1 AND 1000))\n" +
               "AND p.is_existente = true\n" +
               "GROUP BY p.id_product, m.vista_item\n" +
               "HAVING (\n" +
               "\tSELECT SUM(stock_virtual_product) FROM public.producto_talla_color\n" +
               "\tinner join public.talla t ON t.id_talla = producto_talla_color.id_talla_id_talla\n" +
               "\tinner join public.color c ON c.id_color = producto_talla_color.id_color_id_color\n" +
               "\twhere producto_id_product = p.id_product\n" +
               ") > 0\n" +
               "ORDER BY RANDOM()\n" +
               "LIMIT #{cantidad};")
       List<ProductoFilter> randomProduct(  @Param("cantidad") int cantidad,
                                            @Param("categoria") String categoria);


}
