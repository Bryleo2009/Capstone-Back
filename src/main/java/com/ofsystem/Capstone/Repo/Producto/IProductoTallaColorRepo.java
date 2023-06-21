package com.ofsystem.Capstone.Repo.Producto;

import com.ofsystem.Capstone.Model.Enums.Color;
import com.ofsystem.Capstone.Model.Enums.Talla;
import com.ofsystem.Capstone.Model.Producto.Producto;
import com.ofsystem.Capstone.Model.Producto.ProductoTallaColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoTallaColorRepo extends JpaRepository<ProductoTallaColor, Integer> {

    ProductoTallaColor findByProductoAndTallaAndColor(Producto idProducto, Talla idTalla, Color idColor);
    ProductoTallaColor findByProducto_IdProductAndColorAndTalla(int idProducto, Color color, Talla talla);


    @Query("SELECT DISTINCT ptc.talla FROM ProductoTallaColor ptc WHERE ptc.producto = :producto")
    List<Talla> tallas(@Param("producto") Producto producto);

    @Query("SELECT DISTINCT ptc.color FROM ProductoTallaColor ptc WHERE ptc.producto = :producto")
    List<Color> colores(@Param("producto") Producto producto);

}
