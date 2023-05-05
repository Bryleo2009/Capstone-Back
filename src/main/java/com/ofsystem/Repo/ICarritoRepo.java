package com.ofsystem.Repo;

import com.ofsystem.Model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface ICarritoRepo extends JpaRepository<Carrito, Integer> {

}
