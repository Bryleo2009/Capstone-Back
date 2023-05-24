package com.ofsystem.Service.Imple;

import com.ofsystem.Model.TrazabilidadPedidos;
import com.ofsystem.Repo.ITrazabilidadPedidosRepo;
import com.ofsystem.Service.ITrazabilidadPedidosService;
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
