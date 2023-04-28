select p.id_product, p.nombre_product, p.stock_compro_product, p.stock_real_product, p.imagen, p.precio_uni,
p.is_precio_desc_product, p.precio_descu_product, m.vista_item as marca,
string_agg(distinct (e.vista_item), ', ') as etiquetas, string_agg(distinct (t.vista_item), ', ') as tallas from public.producto p
inner join public.categoria_product ct ON ct.id_categ = p.id_categ
inner join public.tipo_producto tp on tp.id_tipo_produc = p.id_tipo_produc
inner join public.producto_id_etiqueta ON producto_id_etiqueta.producto_id_product = p.id_product
inner join public.etiquetas e ON e.id_etiqueta = producto_id_etiqueta.id_etiqueta_id_etiqueta
inner join public.producto_id_talla ON producto_id_talla.producto_id_product = p.id_product
inner join public.talla t ON t.id_talla = producto_id_talla.id_talla_id_talla
inner join public.marcas m ON m.id_marca = p.id_marca
where (ct.abrevi_item = 'CAB'  OR COALESCE('CAB' , '') = '')
AND (tp.abrevi_item IN ( 'CAM' ) OR COALESCE('CAM', '') = '')
AND (e.abrevi_item IN ( 'CBLUE' ) OR COALESCE('CBLUE', '') = '')
AND (t.abrevi_item IN ( 'L' ) OR COALESCE('L', '') = '')
AND (m.abrevi_item IN ( 'ADD' ) OR COALESCE( 'ADD', '') = '')
AND ((p.is_precio_desc_product AND p.precio_descu_product BETWEEN 50 AND 1000) OR
(NOT p.is_precio_desc_product AND p.precio_uni BETWEEN 50 AND 1000))
group by p.id_product, m.vista_item
order by p.id_product 
LIMIT ${cantidad} OFFSET ${pagina};

SELECT * FROM public.producto