package com.ofsystem.Service.Imple;

import com.ofsystem.Model.ProductoTalla;
import com.ofsystem.Repo.IProductoTallaRepo;
import com.ofsystem.Service.IProductoTallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoTallaServiceImpl extends CRUDServiceImpl<ProductoTalla, Integer> implements IProductoTallaService{

	@Autowired
	private IProductoTallaRepo repo;
	
	@Override
	protected JpaRepository<ProductoTalla, Integer> getRepo() {
		return repo;
	}

}
