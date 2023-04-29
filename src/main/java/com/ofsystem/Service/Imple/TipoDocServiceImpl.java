package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.TipoDocName;
import com.ofsystem.Model.TipoDoc;
import com.ofsystem.Repo.ITipoDocRepo;
import com.ofsystem.Service.ITipoDocService;
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
