package com.ofsystem.Capstone.Repo.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.TallaName;
import com.ofsystem.Capstone.Model.Enums.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITallaRepo extends JpaRepository<Talla, Integer> {
    boolean existsByIdentItem(TallaName name);
    Talla findByIdentItem(TallaName name);
}
