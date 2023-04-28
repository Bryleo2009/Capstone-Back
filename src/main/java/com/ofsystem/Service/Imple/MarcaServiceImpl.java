package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.MarcaName;
import com.ofsystem.Model.Marca;
import com.ofsystem.Repo.IMarcaRepo;
import com.ofsystem.Service.IMarcaService;
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
