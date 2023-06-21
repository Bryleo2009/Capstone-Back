package com.ofsystem.Capstone.Service.Imple.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.EtiquetaName;
import com.ofsystem.Capstone.Model.Enums.Etiquetas;
import com.ofsystem.Capstone.Repo.Enums.IEtiquetasRepo;
import com.ofsystem.Capstone.Service.Service.Enums.IEtiquetasService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EtiquetasServiceImpl extends CRUDServiceImpl<Etiquetas, Integer> implements IEtiquetasService{

	@Autowired
	private IEtiquetasRepo repo;
	
	@Override
	protected JpaRepository<Etiquetas, Integer> getRepo() {
		return repo;
	}

	public boolean existsByIdent(EtiquetaName name){
		return repo.existsByIdentItem(name);
	}
	public Etiquetas findByNombre(EtiquetaName name){
		return  repo.findByIdentItem(name);
	}



}
