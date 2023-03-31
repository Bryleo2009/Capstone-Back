package com.ofsystem.Repo;

import com.ofsystem.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {

}
