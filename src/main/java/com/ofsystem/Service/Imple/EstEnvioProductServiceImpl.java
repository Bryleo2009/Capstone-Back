package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EstEnvioProductName;
import com.ofsystem.Model.EstEnvioProduct;
import com.ofsystem.Repo.IEstEnvioProductRepo;
import com.ofsystem.Service.IEstEnvioProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstEnvioProductServiceImpl extends CRUDServiceImpl<EstEnvioProduct, Integer> implements IEstEnvioProductService{

	@Autowired
	private IEstEnvioProductRepo repo;
	
	@Override
	protected JpaRepository<EstEnvioProduct, Integer> getRepo() {
		return repo;
	}

	public boolean existsByNombreCateg(EstEnvioProductName nombreCateg){
		return repo.existsByIdentItem(nombreCateg);
	}

	public EstEnvioProduct findByNombreCateg(EstEnvioProductName name){
		return  repo.findByIdentItem(name);
	}
}
