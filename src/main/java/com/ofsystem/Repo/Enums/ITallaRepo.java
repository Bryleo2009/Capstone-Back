package com.ofsystem.Repo.Enums;

import com.ofsystem.Model.Enums.Name.TallaName;
import com.ofsystem.Model.Enums.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITallaRepo extends JpaRepository<Talla, Integer> {
    boolean existsByIdentItem(TallaName name);
    Talla findByIdentItem(TallaName name);
}
