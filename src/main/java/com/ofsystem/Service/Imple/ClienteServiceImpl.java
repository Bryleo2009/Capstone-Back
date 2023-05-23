package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Cliente;
import com.ofsystem.Repo.IClienteRepo;
import com.ofsystem.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends CRUDServiceImpl<Cliente, Integer> implements IClienteService{

	@Autowired
	private IClienteRepo repo;
	
	@Override
	protected JpaRepository<Cliente, Integer> getRepo() {
		return repo;
	}

	@Override
	public Cliente findByNumDocumento(String numDoc) {
		return repo.findByNumDocumento(numDoc);
	}

	@Override
	public Cliente findByIdUserCliente_Username(String nombre) {
		return repo.findByIdUserCliente_Username(nombre);
	}


}
