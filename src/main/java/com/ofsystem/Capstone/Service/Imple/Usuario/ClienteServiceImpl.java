package com.ofsystem.Capstone.Service.Imple.Usuario;

import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Model.Usuario.Cliente;
import com.ofsystem.Capstone.Repo.Usuario.IClienteRepo;
import com.ofsystem.Capstone.Service.Service.Usuario.IClienteService;
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

	@Override
	public boolean existsByCorreo(String correo) {
		return repo.existsByCorreo(correo);
	}

	@Override
	public Cliente findByCorreo(String correo) {
		return repo.findByCorreo(correo);
	}


}
