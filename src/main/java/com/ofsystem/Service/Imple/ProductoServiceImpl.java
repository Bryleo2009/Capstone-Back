package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Producto;
import com.ofsystem.Repo.IProductoRepo;
import com.ofsystem.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends CRUDServiceImpl<Producto, Integer> implements IProductoService{

	@Autowired
	private IProductoRepo repo;
	
	@Override
	protected JpaRepository<Producto, Integer> getRepo() {
		return repo;
	}

	public Page<Producto> listarPaginado(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		return repo.findAll(pageable);
	}
}
