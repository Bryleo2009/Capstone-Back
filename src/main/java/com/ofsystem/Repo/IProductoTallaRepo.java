package com.ofsystem.Repo;

import com.ofsystem.Model.ProductoTalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoTallaRepo extends JpaRepository<ProductoTalla, Integer> {

}
