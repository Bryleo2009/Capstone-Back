package com.ofsystem.Repo;

import com.ofsystem.Model.TipoCompro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoComproRepo extends JpaRepository<TipoCompro, Integer> {

}
