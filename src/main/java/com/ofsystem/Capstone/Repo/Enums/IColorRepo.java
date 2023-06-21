package com.ofsystem.Capstone.Repo.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.ColorName;
import com.ofsystem.Capstone.Model.Enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColorRepo extends JpaRepository<Color, Integer> {
    boolean existsByIdentItem(ColorName nombreCateg);
    Color findByIdentItem(ColorName name);
}
