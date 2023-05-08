package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EstProductName;
import com.ofsystem.Model.EstProduct;
import com.ofsystem.Repo.IEstProductRepo;
import com.ofsystem.Service.IEstProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstProductServiceImpl extends CRUDServiceImpl<EstProduct, Integer> implements IEstProductService {

	@Autowired
	private IEstProductRepo repo;
	
	@Override
	protected JpaRepository<EstProduct, Integer> getRepo() {
		return repo;
	}

	public boolean existsByNombreCateg(EstProductName nombreCateg){
		return repo.existsByIdentItem(nombreCateg);
	}

	public EstProduct findByNombreCateg(EstProductName name){
		return  repo.findByIdentItem(name);
	}
}
