package com.ofsystem.Repo;

import com.ofsystem.Model.ListaDeseos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IListaDeseoRepo extends JpaRepository<ListaDeseos, Integer> {


}
