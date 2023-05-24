package com.ofsystem.Service.Imple.Enums;

import com.ofsystem.Model.Enums.Name.TipoPagoName;
import com.ofsystem.Model.Enums.TipoPago;
import com.ofsystem.Repo.Enums.ITipoPagoRepo;
import com.ofsystem.Service.Service.Enums.ITipoPagoService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
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


	public boolean existsByIdent(TipoPagoName name){
		return repo.existsByIdentItem(name);
	}
}