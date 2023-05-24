package com.ofsystem.Service.Imple.Enums;

import com.ofsystem.Model.Enums.Name.RolName;
import com.ofsystem.Model.Enums.Rol;
import com.ofsystem.Repo.Enums.IRolRepo;
import com.ofsystem.Service.Service.Enums.IRolService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
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
