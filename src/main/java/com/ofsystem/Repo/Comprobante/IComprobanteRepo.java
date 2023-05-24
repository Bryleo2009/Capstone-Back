package com.ofsystem.Repo;

import com.ofsystem.Model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComprobanteRepo extends JpaRepository<Comprobante, String> {

}
