package com.ofsystem.Capstone.Service.Imple.Usuario;

import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Service.Service.Usuario.ITrabajadorService;
import com.ofsystem.Capstone.Model.Usuario.Trabajador;
import com.ofsystem.Capstone.Repo.Usuario.ITrabajadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TrabajadorServiceImpl extends CRUDServiceImpl<Trabajador, Integer> implements ITrabajadorService {

	@Autowired
	private ITrabajadorRepo repo;
	
	@Override
	protected JpaRepository<Trabajador, Integer> getRepo() {
		return repo;
	}

	@Override
	public Trabajador findByIdUserCliente_Username(String username) {
		return repo.findByIdUserCliente_Username(username);
	}
}
