package com.ofsystem.Repo;

import com.ofsystem.Model.ProductoTallaColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoTallaColorRepo extends JpaRepository<ProductoTallaColor, Integer> {

}
