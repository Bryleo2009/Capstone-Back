package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Usuario.Trabajador;
import com.ofsystem.Repo.ITrabajadorRepo;
import com.ofsystem.Service.ITrabajadorService;
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

}
