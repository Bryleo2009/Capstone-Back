package com.ofsystem.Repo.Producto;

import com.ofsystem.Model.Enums.Color;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Producto.ProductoTallaColor;
import com.ofsystem.Model.Enums.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoTallaColorRepo extends JpaRepository<ProductoTallaColor, Integer> {

    ProductoTallaColor findByProductoAndTallaAndColor(Producto idProducto, Talla idTalla, Color idColor);

}
