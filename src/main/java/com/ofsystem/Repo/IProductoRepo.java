package com.ofsystem.Repo;

import com.ofsystem.Model.Producto;
import com.ofsystem.Model.Talla;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Integer> {
    boolean existsByNombreProduct(String name);
    List<Producto> findProductoByIUPContaining(String iup);

}
