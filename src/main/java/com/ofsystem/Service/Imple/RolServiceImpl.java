package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.RolName;
import com.ofsystem.Model.Rol;
import com.ofsystem.Repo.IRolRepo;
import com.ofsystem.Service.IRolService;
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
