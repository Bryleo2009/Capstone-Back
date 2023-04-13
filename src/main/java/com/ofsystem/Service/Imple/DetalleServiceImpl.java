package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Detalle;
import com.ofsystem.Repo.IDetalleRepo;
import com.ofsystem.Service.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl extends CRUDServiceImpl<Detalle, Integer> implements IDetalleService{

	@Autowired
	private IDetalleRepo repo;
	
	@Override
	protected JpaRepository<Detalle, Integer> getRepo() {
		return repo;
	}

}
