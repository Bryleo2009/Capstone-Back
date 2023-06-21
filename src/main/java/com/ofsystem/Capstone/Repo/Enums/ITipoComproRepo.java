package com.ofsystem.Capstone.Repo.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.TipoComproName;
import com.ofsystem.Capstone.Model.Enums.TipoCompro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoComproRepo extends JpaRepository<TipoCompro, Integer> {

    boolean existsByIdentItem( TipoComproName nombreCateg);
    TipoCompro findByIdentItem(TipoComproName name);

}
