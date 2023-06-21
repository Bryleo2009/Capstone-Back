package com.ofsystem.Capstone.Repo.Producto;

import com.ofsystem.Capstone.Model.Producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Integer> {
    boolean existsByNombreProduct(String name);
    List<Producto> findProductoByIUPContaining(String iup);

    List<Producto> findProductoByIsExistenteIsTrue ();
}
