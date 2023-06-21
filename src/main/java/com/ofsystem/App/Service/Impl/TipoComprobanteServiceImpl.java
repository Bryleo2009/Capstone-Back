package com.ofsystem.App.Service.Impl;

import com.ofsystem.App.Model.TipoComprobante;
import com.ofsystem.App.Repo.ITipoComprobanteRepo;
import com.ofsystem.App.Service.ITipoComprobanteService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoComprobanteServiceImpl extends CRUDServiceImpl<TipoComprobante, Integer> implements ITipoComprobanteService{
	@Autowired
	private ITipoComprobanteRepo repo;
	
	@Override
	protected JpaRepository<TipoComprobante, Integer> getRepo() {
		return repo;
	}

}
