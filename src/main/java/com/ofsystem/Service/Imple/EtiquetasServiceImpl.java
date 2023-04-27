package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Model.Etiquetas;
import com.ofsystem.Model.TipoProducto;
import com.ofsystem.Repo.IEtiquetasRepo;
import com.ofsystem.Service.IEtiquetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EtiquetasServiceImpl extends CRUDServiceImpl<Etiquetas, Integer> implements IEtiquetasService{

	@Autowired
	private IEtiquetasRepo repo;
	
	@Override
	protected JpaRepository<Etiquetas, Integer> getRepo() {
		return repo;
	}

	public boolean existsByIdent(EtiquetaName name){
		return repo.existsByIdentItem(name);
	}
	public Etiquetas findByNombre(EtiquetaName name){
		return  repo.findByIdentItem(name);
	}

}
