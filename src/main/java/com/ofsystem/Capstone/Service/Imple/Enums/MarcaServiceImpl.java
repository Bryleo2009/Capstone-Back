package com.ofsystem.Capstone.Service.Imple.Enums;

import com.ofsystem.Capstone.Repo.Enums.IMarcaRepo;
import com.ofsystem.Capstone.Model.Enums.Name.MarcaName;
import com.ofsystem.Capstone.Model.Enums.Marca;
import com.ofsystem.Capstone.Service.Service.Enums.IMarcaService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl extends CRUDServiceImpl<Marca, Integer> implements IMarcaService{

	@Autowired
	private IMarcaRepo repo;
	
	@Override
	protected JpaRepository<Marca, Integer> getRepo() {
		return repo;
	}

	public boolean existsByIdent(MarcaName name){
		return repo.existsByIdentItem(name);
	}
	public Marca findByNombre(MarcaName name){
		return  repo.findByIdentItem(name);
	}

}
