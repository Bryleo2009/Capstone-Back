package com.ofsystem.Capstone.Service.Imple.Comprobante;

import com.ofsystem.Capstone.Mapper.Filter.ComprobanteDFilter;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Mapper.IComprobanteMapper;
import com.ofsystem.Capstone.Model.Comprobante.Comprobante;
import com.ofsystem.Capstone.Repo.Comprobante.IComprobanteRepo;
import com.ofsystem.Capstone.Service.Service.Comprobante.IComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprobanteServiceImpl extends CRUDServiceImpl<Comprobante, String> implements IComprobanteService{

	@Autowired
	private IComprobanteRepo repo;
	@Autowired
	private IComprobanteMapper repoMapper;
	
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

	@Override
	public List<ComprobanteDFilter> ListarComprobanteXID(String idComp){
		return repoMapper.ListarComprobanteXID(idComp);
	}


}
