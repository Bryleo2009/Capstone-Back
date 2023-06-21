package com.ofsystem.Capstone.Repo.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.EstComproName;
import com.ofsystem.Capstone.Model.Enums.EstCompro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstComproRepo extends JpaRepository<EstCompro, Integer> {
    boolean existsByIdentItem(EstComproName nombreCateg);
    EstCompro findByIdentItem(EstComproName name);
}
