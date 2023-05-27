package com.ofsystem.Service.Imple.Enums;

import com.ofsystem.Model.Enums.Name.TallaName;
import com.ofsystem.Mapper.Filter.TallaFilter;
import com.ofsystem.Mapper.ITallaMapper;
import com.ofsystem.Model.Enums.Talla;
import com.ofsystem.Repo.Enums.ITallaRepo;
import com.ofsystem.Service.Service.Enums.ITallaService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
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
