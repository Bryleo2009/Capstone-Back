package com.ofsystem.Capstone.Service.Imple.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.RolName;
import com.ofsystem.Capstone.Model.Enums.Rol;
import com.ofsystem.Capstone.Repo.Enums.IRolRepo;
import com.ofsystem.Capstone.Service.Service.Enums.IRolService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends CRUDServiceImpl<Rol, Integer> implements IRolService{

	@Autowired
	private IRolRepo repo;
	
	@Override
	protected JpaRepository<Rol, Integer> getRepo() {
		return repo;
	}

	public boolean existsByIdent(RolName name){
		return repo.existsByIdentItem(name);
	}
	public Rol findByNombreItem(String name){
		return repo.findByNombreItem(name);
	}

}
