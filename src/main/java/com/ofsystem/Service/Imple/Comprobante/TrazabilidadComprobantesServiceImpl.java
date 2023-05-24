package com.ofsystem.Service.Imple.Comprobante;

import com.ofsystem.Model.Comprobante.TrazabilidadComprobantes;
import com.ofsystem.Repo.Comprobante.ITrazabilidadComprobantesRepo;
import com.ofsystem.Service.Service.Comprobante.ITrazabilidadComprobantesService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TrazabilidadComprobantesServiceImpl extends CRUDServiceImpl<TrazabilidadComprobantes, Integer> implements ITrazabilidadComprobantesService{

	@Autowired
	private ITrazabilidadComprobantesRepo repo;
	
	@Override
	protected JpaRepository<TrazabilidadComprobantes, Integer> getRepo() {
		return repo;
	}

}
