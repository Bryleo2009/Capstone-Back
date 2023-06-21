package com.ofsystem.Capstone.Service.Imple.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.EstComproName;
import com.ofsystem.Capstone.Model.Enums.EstCompro;
import com.ofsystem.Capstone.Repo.Enums.IEstComproRepo;
import com.ofsystem.Capstone.Service.Service.Enums.IEstComproService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
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
