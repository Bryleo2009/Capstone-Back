package com.ofsystem.Repo.Cliente;

import com.ofsystem.Model.Cliente.PaqueteProductos;
import com.ofsystem.Model.Usuario.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IPaqueteProductosRepo extends JpaRepository<PaqueteProductos, Integer> {

    List<PaqueteProductos> findByIdClienteAndAndFechaPedidoProduc (Cliente unCliente, Date unaFecha);
    @Query(value = "SELECT id FROM public.pedido_id_producto order by id desc limit 1;", nativeQuery = true)
    int idPedido();
}
