package com.ofsystem.Service.Imple;

import com.ofsystem.Model.TrazabilidadComprobantes;
import com.ofsystem.Repo.ITrazabilidadComprobantesRepo;
import com.ofsystem.Service.ITrazabilidadComprobantesService;
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
