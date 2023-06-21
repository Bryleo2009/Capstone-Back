package com.ofsystem.Capstone.Service.Imple.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.TipoDocName;
import com.ofsystem.Capstone.Model.Enums.TipoDoc;
import com.ofsystem.Capstone.Repo.Enums.ITipoDocRepo;
import com.ofsystem.Capstone.Service.Service.Enums.ITipoDocService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoDocServiceImpl extends CRUDServiceImpl<TipoDoc, Integer> implements ITipoDocService{

	@Autowired
	private ITipoDocRepo repo;
	
	@Override
	protected JpaRepository<TipoDoc, Integer> getRepo() {
		return repo;
	}

	public boolean existsByNombreTipoDoc(TipoDocName TipoDocName){
		return repo.existsByIdentItem(TipoDocName);
	}

	public TipoDoc findByNombre(TipoDocName name){
		return  repo.findByIdentItem(name);
	}

}
