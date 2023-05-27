package com.ofsystem.Service.Imple.Usuario;

import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Repo.Usuario.IClienteRepo;
import com.ofsystem.Service.Service.Usuario.IClienteService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
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
