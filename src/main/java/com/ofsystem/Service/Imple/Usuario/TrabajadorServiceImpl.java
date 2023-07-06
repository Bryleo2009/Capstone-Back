package com.ofsystem.Service.Imple.Usuario;

import com.ofsystem.Model.Usuario.Trabajador;
import com.ofsystem.Repo.Usuario.ITrabajadorRepo;
import com.ofsystem.Service.Service.Usuario.ITrabajadorService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TrabajadorServiceImpl extends CRUDServiceImpl<Trabajador, Integer> implements ITrabajadorService{

	@Autowired
	private ITrabajadorRepo repo;
	
	@Override
	protected JpaRepository<Trabajador, Integer> getRepo() {
		return repo;
	}

	@Override
	public Trabajador findByIdUserCliente_Username(String username) {
		return repo.findByIdUserTrabajador_Username(username);
	}
}
