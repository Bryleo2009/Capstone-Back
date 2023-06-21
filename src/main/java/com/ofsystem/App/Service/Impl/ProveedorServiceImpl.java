package com.ofsystem.App.Service.Impl;

import com.ofsystem.App.Model.Proveedor;
import com.ofsystem.App.Repo.IProveedorRepo;
import com.ofsystem.App.Service.IProveedorService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends CRUDServiceImpl<Proveedor, String> implements IProveedorService{
	@Autowired
	private IProveedorRepo repo;
	
	@Override
	protected JpaRepository<Proveedor, String> getRepo() {
		return repo;
	}

}
