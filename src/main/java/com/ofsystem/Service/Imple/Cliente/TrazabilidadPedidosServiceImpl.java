package com.ofsystem.Service.Imple.Cliente;

import com.ofsystem.Model.Cliente.TrazabilidadPedidos;
import com.ofsystem.Repo.Cliente.ITrazabilidadPedidosRepo;
import com.ofsystem.Service.Service.Cliente.ITrazabilidadPedidosService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TrazabilidadPedidosServiceImpl extends CRUDServiceImpl<TrazabilidadPedidos, Integer> implements ITrazabilidadPedidosService{

	@Autowired
	private ITrazabilidadPedidosRepo repo;
	
	@Override
	protected JpaRepository<TrazabilidadPedidos, Integer> getRepo() {
		return repo;
	}

}
