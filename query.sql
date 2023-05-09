--productos
INSERT INTO public.producto(
	descripcion_product, imagen, is_precio_desc_product,
	nombre_product, precio_descu_product, precio_uni, stock_compro_product,
	stock_real_product, id_categ, id_marca, id_tipo_produc)
VALUES ('Composicion: 75% Algodón, 25% Algodón, Reciclado | Tiro para prendas: Bajo', null, true,
		   'Jean Baggy Mujer Sybilla',90.93,129.90,5,5,
		   2,5,5);
INSERT INTO public.producto(
	descripcion_product, imagen, is_precio_desc_product,
	nombre_product, precio_descu_product, precio_uni, stock_compro_product,
	stock_real_product, id_categ, id_marca, id_tipo_produc)
VALUES ('Composición	TOP: 60% Algodón 40% Poliéster / SKIRT: 100% Poliéster', null, true,
		   'Conjunto Niña Algodón Minnie',71.90,119.90,5,5,
		   3,6,6);
INSERT INTO public.producto(
	descripcion_product, imagen, is_precio_desc_product,
	nombre_product, precio_descu_product, precio_uni, stock_compro_product,
	stock_real_product, id_categ, id_marca, id_tipo_produc)
VALUES ('Una billetera de diseño clásico nunca pasa de moda. Irina llega esta temporada con una paleta de colores frescos y juveniles', null, false,
		   'Billetera Mujer Crepier Irina Amarillo ocre',null,139,5,5,
		   4,7,7);


--tallas - Productos
INSERT INTO public.producto_id_talla VALUES (2,7),(2,8),(2,9),(2,10),(2,11),(2,12);
INSERT INTO public.producto_id_talla VALUES (3,32),(3,33),(3,34),(3,35),(3,36);
INSERT INTO public.producto_id_talla VALUES (4,31);


--color - productos
INSERT INTO public.producto_id_color VALUES (2,8);
INSERT INTO public.producto_id_color VALUES (3,9);
INSERT INTO public.producto_id_color VALUES (4,9);

--etiqueta - productos
INSERT INTO public.producto_id_etiqueta VALUES (2,5),(2,6),(2,7);
INSERT INTO public.producto_id_etiqueta VALUES (3,5),(3,6),(3,7);
INSERT INTO public.producto_id_etiqueta VALUES (4,8);







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





SELECT t.* FROM public.producto_id_talla
inner join public.talla t ON t.id_talla = producto_id_talla.id_talla_id_talla
where producto_id_product = 33 and stock_real_product > 0;


select * from public.producto_id_talla