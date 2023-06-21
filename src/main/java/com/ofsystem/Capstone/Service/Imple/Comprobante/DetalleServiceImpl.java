package com.ofsystem.Capstone.Service.Imple.Comprobante;

import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Service.Service.Comprobante.IDetalleService;
import com.ofsystem.Capstone.Model.Comprobante.Detalle;
import com.ofsystem.Capstone.Repo.Comprobante.IDetalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleServiceImpl extends CRUDServiceImpl<Detalle, Integer> implements IDetalleService {

	@Autowired
	private IDetalleRepo repo;
	
	@Override
	protected JpaRepository<Detalle, Integer> getRepo() {
		return repo;
	}

	@Override
	public int idDetalle() {
		return repo.idDetalle();
	}

	@Override
	public List<Detalle> findByIdComp_Iuc(String iuc) {
		return repo.findByIdComp_Iuc(iuc);
	}
}
