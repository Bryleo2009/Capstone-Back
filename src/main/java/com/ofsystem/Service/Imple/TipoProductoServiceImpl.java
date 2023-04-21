package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Model.TipoProducto;
import com.ofsystem.Repo.ITipoProductoRepo;
import com.ofsystem.Service.ITipoProductoService;
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
		return repo.existsByNombreTipoProduc(tipoProductoName);
	}
}
