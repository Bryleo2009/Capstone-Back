package com.ofsystem.Capstone.Repo.Comprobante;

import com.ofsystem.Capstone.Model.Comprobante.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IComprobanteRepo extends JpaRepository<Comprobante, String> {

    @Query(value = "SELECT c.id_comp FROM Comprobante c ORDER BY c.id_comp DESC LIMIT 1", nativeQuery = true)
    String findLastIdComp();

    Comprobante findByIuc(String iuc);
}
