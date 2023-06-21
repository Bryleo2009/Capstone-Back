package com.ofsystem.Capstone.Repo.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.RolName;
import com.ofsystem.Capstone.Model.Enums.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepo extends JpaRepository<Rol, Integer> {

    boolean existsByIdentItem( RolName nombreCateg);
    Rol findByIdentItem(RolName name);

    Rol findByNombreItem(String name);

}
