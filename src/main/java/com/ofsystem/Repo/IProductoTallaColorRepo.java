package com.ofsystem.Repo;

import com.ofsystem.Model.Color;
import com.ofsystem.Model.Producto;
import com.ofsystem.Model.ProductoTallaColor;
import com.ofsystem.Model.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoTallaColorRepo extends JpaRepository<ProductoTallaColor, Integer> {

    ProductoTallaColor findByProductoAndTallaAndColor(Producto idProducto, Talla idTalla, Color idColor);

}
