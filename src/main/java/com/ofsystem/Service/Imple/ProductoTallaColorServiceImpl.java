package com.ofsystem.Service.Imple;

import com.ofsystem.Model.ProductoTallaColor;
import com.ofsystem.Repo.IProductoTallaColorRepo;
import com.ofsystem.Service.IProductoTallaColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoTallaColorServiceImpl extends CRUDServiceImpl<ProductoTallaColor, Integer> implements IProductoTallaColorService {

	@Autowired
	private IProductoTallaColorRepo repo;
	
	@Override
	protected JpaRepository<ProductoTallaColor, Integer> getRepo() {
		return repo;
	}

}
