package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TallaName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Model.Talla;
import com.ofsystem.Model.TipoProducto;
import com.ofsystem.Repo.ITallaRepo;
import com.ofsystem.Service.ITallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TallaServiceImpl extends CRUDServiceImpl<Talla, Integer> implements ITallaService{

	@Autowired
	private ITallaRepo repo;
	
	@Override
	protected JpaRepository<Talla, Integer> getRepo() {
		return repo;
	}

	public boolean existsByNombreTalla(TallaName name){
		return repo.existsByIdentItem(name);
	}

	public Talla findByNombre(TallaName name){
		return  repo.findByIdentItem(name);
	}


}
