package com.ofsystem.Repo;

import com.ofsystem.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Integer> {
    boolean existsByNombreProduct(String name);
}
