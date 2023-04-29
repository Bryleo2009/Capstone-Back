package com.ofsystem.Repo;

import com.ofsystem.Enums.RolName;
import com.ofsystem.Enums.TipoComproName;
import com.ofsystem.Model.Rol;
import com.ofsystem.Model.TipoCompro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepo extends JpaRepository<Rol, Integer> {

    boolean existsByIdentItem( RolName nombreCateg);
    Rol findByIdentItem(RolName name);

}
