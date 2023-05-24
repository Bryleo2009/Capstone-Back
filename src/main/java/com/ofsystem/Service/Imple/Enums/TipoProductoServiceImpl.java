package com.ofsystem.Service.Imple.Enums;

import com.ofsystem.Model.Enums.Name.TipoProductoName;
import com.ofsystem.Model.Enums.TipoProducto;
import com.ofsystem.Repo.Enums.ITipoProductoRepo;
import com.ofsystem.Service.Service.Enums.ITipoProductoService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoServiceImpl extends CRUDServiceImpl<TipoProducto, Integer> implements ITipoProductoService{

	@Autowired
	private ITipoProductoRepo repo;
	
	@Override
	protected JpaRepository<TipoProducto, Integer> getRepo() {
		return repo;
	}

	public boolean existsByNombreTipoProduc(TipoProductoName tipoProductoName){
		return repo.existsByIdentItem(tipoProductoName);
	}

	public TipoProducto findByNombre(TipoProductoName name){
		return  repo.findByIdentItem(name);
	}

}
