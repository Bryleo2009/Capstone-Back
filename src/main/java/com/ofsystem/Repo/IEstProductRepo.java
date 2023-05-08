package com.ofsystem.Repo;

import com.ofsystem.Enums.EstProductName;
import com.ofsystem.Model.EstProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstProductRepo extends JpaRepository<EstProduct, Integer> {
    boolean existsByIdentItem(EstProductName nombreCateg);
    EstProduct findByIdentItem(EstProductName name);
}
