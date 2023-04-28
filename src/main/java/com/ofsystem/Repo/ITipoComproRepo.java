package com.ofsystem.Repo;

import com.ofsystem.Enums.EstEnvioProductName;
import com.ofsystem.Enums.TipoComproName;
import com.ofsystem.Model.EstEnvioProduct;
import com.ofsystem.Model.TipoCompro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoComproRepo extends JpaRepository<TipoCompro, Integer> {

    boolean existsByIdentItem( TipoComproName nombreCateg);
    TipoCompro findByIdentItem(TipoComproName name);

}
