package com.ofsystem.Repo;

import com.ofsystem.Enums.EstComproName;
import com.ofsystem.Model.EstCompro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstComproRepo extends JpaRepository<EstCompro, Integer> {
    boolean existsByIdentItem(EstComproName nombreCateg);
    EstCompro findByIdentItem(EstComproName name);
}
