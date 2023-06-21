package com.ofsystem.Capstone.Service.Imple.Cliente;

import com.ofsystem.Capstone.Model.Cliente.TrazabilidadPedidos;
import com.ofsystem.Capstone.Repo.Cliente.ITrazabilidadPedidosRepo;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Service.Service.Cliente.ITrazabilidadPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TrazabilidadPedidosServiceImpl extends CRUDServiceImpl<TrazabilidadPedidos, Integer> implements ITrazabilidadPedidosService {

	@Autowired
	private ITrazabilidadPedidosRepo repo;
	
	@Override
	protected JpaRepository<TrazabilidadPedidos, Integer> getRepo() {
		return repo;
	}

}
