package com.ofsystem.App.Service.Impl;

import com.ofsystem.App.Model.MedioPago;
import com.ofsystem.App.Repo.IMedioPagoRepo;
import com.ofsystem.App.Service.IMedioPagoService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MedioPagoServiceImpl extends CRUDServiceImpl<MedioPago, Integer> implements IMedioPagoService{
	@Autowired
	private IMedioPagoRepo repo;
	
	@Override
	protected JpaRepository<MedioPago, Integer> getRepo() {
		return repo;
	}

}
