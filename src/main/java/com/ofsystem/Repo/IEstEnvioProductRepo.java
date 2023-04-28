package com.ofsystem.Repo;

import com.ofsystem.Enums.EstEnvioProductName;
import com.ofsystem.Model.EstEnvioProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstEnvioProductRepo extends JpaRepository<EstEnvioProduct, Integer> {
    boolean existsByIdentItem(EstEnvioProductName nombreCateg);
    EstEnvioProduct findByIdentItem(EstEnvioProductName name);
}
