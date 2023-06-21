package com.ofsystem.Capstone.Service.Imple.Comprobante;

import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Service.Service.Comprobante.ITrazabilidadComprobantesService;
import com.ofsystem.Capstone.Model.Comprobante.TrazabilidadComprobantes;
import com.ofsystem.Capstone.Repo.Comprobante.ITrazabilidadComprobantesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TrazabilidadComprobantesServiceImpl extends CRUDServiceImpl<TrazabilidadComprobantes, Integer> implements ITrazabilidadComprobantesService {

	@Autowired
	private ITrazabilidadComprobantesRepo repo;
	
	@Override
	protected JpaRepository<TrazabilidadComprobantes, Integer> getRepo() {
		return repo;
	}

}
