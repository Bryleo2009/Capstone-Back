package com.ofsystem.Repo.Comprobante;

import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Model.Usuario.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IComprobanteRepo extends JpaRepository<Comprobante, String> {

    @Query(value = "SELECT c.id_comp FROM Comprobante c ORDER BY c.id_comp DESC LIMIT 1", nativeQuery = true)
    String findLastIdComp();

    Comprobante findByIuc(String iuc);
}
