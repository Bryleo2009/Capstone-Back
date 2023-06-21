package com.ofsystem.App.Repo;

import com.ofsystem.App.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedorRepo extends JpaRepository<Proveedor, String> {

}
