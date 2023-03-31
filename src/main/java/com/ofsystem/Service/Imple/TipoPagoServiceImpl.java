package com.ofsystem.Service.Imple;

import com.ofsystem.Model.TipoPago;
import com.ofsystem.Repo.ITipoPagoRepo;
import com.ofsystem.Service.ITipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoPagoServiceImpl extends CRUDServiceImpl<TipoPago, Integer> implements ITipoPagoService{

	@Autowired
	private ITipoPagoRepo repo;
	
	@Override
	protected JpaRepository<TipoPago, Integer> getRepo() {
		return repo;
	}

}
