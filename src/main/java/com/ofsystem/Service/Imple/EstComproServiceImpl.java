package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EstComproName;
import com.ofsystem.Model.EstCompro;
import com.ofsystem.Repo.IEstComproRepo;
import com.ofsystem.Service.IEstComproService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstComproServiceImpl extends CRUDServiceImpl<EstCompro, Integer> implements IEstComproService{

	@Autowired
	private IEstComproRepo repo;
	
	@Override
	protected JpaRepository<EstCompro, Integer> getRepo() {
		return repo;
	}

	public boolean existsByNombreCateg(EstComproName nombreCateg){
		return repo.existsByIdentItem(nombreCateg);
	}

	public EstCompro findByNombreCateg(EstComproName name){
		return  repo.findByIdentItem(name);
	}
}
