package com.ofsystem.Service.Imple.Comprobante;

import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Repo.Comprobante.IComprobanteRepo;
import com.ofsystem.Service.Service.Comprobante.IComprobanteService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ComprobanteServiceImpl extends CRUDServiceImpl<Comprobante, String> implements IComprobanteService{

	@Autowired
	private IComprobanteRepo repo;
	
	@Override
	protected JpaRepository<Comprobante, String> getRepo() {
		return repo;
	}

	@Override
	public String findLastIdComp() {
		return repo.findLastIdComp();
	}

	@Override
	public Comprobante findByIuc(String iuc) {
		return repo.findByIuc(iuc);
	}


}
