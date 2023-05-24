package com.ofsystem.Repo.Enums;

import com.ofsystem.Model.Enums.Name.EstComproName;
import com.ofsystem.Model.Enums.EstCompro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstComproRepo extends JpaRepository<EstCompro, Integer> {
    boolean existsByIdentItem(EstComproName nombreCateg);
    EstCompro findByIdentItem(EstComproName name);
}
