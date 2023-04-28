package com.ofsystem.Repo;

import com.ofsystem.Enums.ColorName;
import com.ofsystem.Model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColorRepo extends JpaRepository<Color, Integer> {
    boolean existsByIdentItem(ColorName nombreCateg);
    Color findByIdentItem(ColorName name);
}
