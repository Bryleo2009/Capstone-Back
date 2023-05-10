
----filtrado de productos
SELECT 
    p.id_product, 
	p.iup, 
    p.nombre_product, 
    p.imagen, 
    p.precio_uni,
    p.is_precio_desc_product, 
    p.precio_descu_product, 
    m.vista_item as marca,	
    string_agg(DISTINCT e.vista_item, ', ') as etiquetas, 
    string_agg(DISTINCT t.vista_item, ', ') as tallas, 
    string_agg(DISTINCT c.vista_item, ', ') as colores
FROM public.producto p
INNER JOIN public.categoria_product ct ON ct.id_categ = p.id_categ
INNER JOIN public.tipo_producto tp ON tp.id_tipo_produc = p.id_tipo_produc
INNER JOIN public.producto_id_etiqueta ON producto_id_etiqueta.producto_id_product = p.id_product
INNER JOIN public.etiquetas e ON e.id_etiqueta = producto_id_etiqueta.id_etiqueta_id_etiqueta
INNER JOIN public.producto_talla_color ptc ON ptc.producto_id_product = p.id_product
INNER JOIN public.talla t ON t.id_talla = ptc.id_talla_id_talla
INNER JOIN public.color c ON c.id_color = ptc.id_color_id_color
INNER JOIN public.marcas m ON m.id_marca = p.id_marca
WHERE 
    (ct.abrevi_item = ''  OR COALESCE('' , '') = '')
AND (tp.abrevi_item IN ( '' ) OR COALESCE('', '') = '')
AND (e.abrevi_item IN ( '' ) OR COALESCE('', '') = '')
AND (c.abrevi_item IN ( '' ) OR COALESCE('', '') = '')
AND (t.abrevi_item IN ( '' ) OR COALESCE('', '') = '')
AND (m.abrevi_item IN ( '' ) OR COALESCE( '', '') = '')
AND ((p.is_precio_desc_product AND p.precio_descu_product BETWEEN 10 AND 1000) OR
(NOT p.is_precio_desc_product AND p.precio_uni BETWEEN 10 AND 1000))
AND p.is_existente = true
GROUP BY p.id_product, m.vista_item
HAVING (
	SELECT SUM(stock_real_product) FROM public.producto_talla_color
	inner join public.talla t ON t.id_talla = producto_talla_color.id_talla_id_talla
	inner join public.color c ON c.id_color = producto_talla_color.id_color_id_color
	where 
		(t.abrevi_item IN ( '' ) OR COALESCE('', '') = '')
	AND (c.abrevi_item IN ( '' ) OR COALESCE('', '') = '')
	AND producto_id_product = p.id_product
) > 0
ORDER BY p.id_product
LIMIT ${cantidad} OFFSET ${pagina};

---filtrado de colores y tallas
select t.* from producto_talla_color ptc
inner join talla t ON t.id_talla = ptc.id_talla_id_talla
where ptc.stock_virtual_product > 0 and ptc.existe_noexiste = true and ptc.producto_id_product = 2
group by t.id_talla, t.abrevi_item, t.ident_item, t.vista_item;

select c.* from producto_talla_color ptc
inner join color c ON c.id_color = ptc.id_color_id_color
where ptc.stock_virtual_product > 0 and ptc.existe_noexiste = true and ptc.producto_id_product = 2
group by c.id_color, c.abrevi_item, c.ident_item, c.vista_item;


--ropa aleatoria
SELECT 
    p.id_product, 
	p.iup, 
    p.nombre_product, 
    p.imagen, 
    p.precio_uni,
    p.is_precio_desc_product, 
    p.precio_descu_product, 
    m.vista_item as marca,	
    string_agg(DISTINCT e.vista_item, ', ') as etiquetas, 
    string_agg(DISTINCT t.vista_item, ', ') as tallas, 
    string_agg(DISTINCT c.vista_item, ', ') as colores
FROM public.producto p
INNER JOIN public.categoria_product ct ON ct.id_categ = p.id_categ
INNER JOIN public.tipo_producto tp ON tp.id_tipo_produc = p.id_tipo_produc
INNER JOIN public.producto_id_etiqueta ON producto_id_etiqueta.producto_id_product = p.id_product
INNER JOIN public.etiquetas e ON e.id_etiqueta = producto_id_etiqueta.id_etiqueta_id_etiqueta
INNER JOIN public.producto_talla_color ptc ON ptc.producto_id_product = p.id_product
INNER JOIN public.talla t ON t.id_talla = ptc.id_talla_id_talla
INNER JOIN public.color c ON c.id_color = ptc.id_color_id_color
INNER JOIN public.marcas m ON m.id_marca = p.id_marca
WHERE (ct.abrevi_item = ''  OR COALESCE('' , '') = '')
AND ((p.is_precio_desc_product AND p.precio_descu_product BETWEEN 1 AND 1000) OR
(NOT p.is_precio_desc_product AND p.precio_uni BETWEEN 1 AND 1000))
AND p.is_existente = true
GROUP BY p.id_product, m.vista_item
HAVING (
	SELECT SUM(stock_virtual_product) FROM public.producto_talla_color
	inner join public.talla t ON t.id_talla = producto_talla_color.id_talla_id_talla
	inner join public.color c ON c.id_color = producto_talla_color.id_color_id_color
	where producto_id_product = p.id_product
) > 0
ORDER BY RANDOM()
LIMIT 10;



