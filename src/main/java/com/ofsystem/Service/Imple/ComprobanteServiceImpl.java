package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Comprobante;
import com.ofsystem.Repo.IComprobanteRepo;
import com.ofsystem.Service.IComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteServiceImpl extends CRUDServiceImpl<Comprobante, String> implements IComprobanteService{

	@Autowired
	private IComprobanteRepo repo;
	
	@Override
	protected JpaRepository<Comprobante, String> getRepo() {
		return repo;
	}

}
