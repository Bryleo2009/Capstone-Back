package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TipoComproName;
import com.ofsystem.Model.TipoCompro;
import com.ofsystem.Repo.ITipoComproRepo;
import com.ofsystem.Service.ITipoComproService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoComproServiceImpl extends CRUDServiceImpl<TipoCompro, Integer> implements ITipoComproService{

	@Autowired
	private ITipoComproRepo repo;


	@Override
	protected JpaRepository<TipoCompro, Integer> getRepo() {
		return repo;
	}

	public boolean existsByIdent(TipoComproName name){
		return repo.existsByIdentItem(name);
	}

}
