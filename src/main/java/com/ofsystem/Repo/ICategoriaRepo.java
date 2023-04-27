package com.ofsystem.Repo;

import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {
    boolean existsByIdentItem(CategoriaName nombreCateg);
    Categoria findByIdentItem(CategoriaName name);
}
