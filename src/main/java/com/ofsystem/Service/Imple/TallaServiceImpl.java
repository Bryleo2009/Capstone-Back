package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TallaName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Mapper.Filter.TallaFilter;
import com.ofsystem.Mapper.ITallaMapper;
import com.ofsystem.Model.Talla;
import com.ofsystem.Model.TipoProducto;
import com.ofsystem.Repo.ITallaRepo;
import com.ofsystem.Service.ITallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallaServiceImpl extends CRUDServiceImpl<Talla, Integer> implements ITallaService{

	@Autowired
	private ITallaRepo repo;

	@Autowired
	private ITallaMapper repoMapper;
	
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

	public List<TallaFilter> listarTallasxID (int id){
		return repoMapper.listarTallasxID(id);
	}

}
