package com.ofsystem.Service.Imple.Enums;

import com.ofsystem.Model.Enums.Name.ColorName;
import com.ofsystem.Mapper.Filter.ColorFilter;
import com.ofsystem.Mapper.IColorMapper;
import com.ofsystem.Model.Enums.Color;
import com.ofsystem.Repo.Enums.IColorRepo;
import com.ofsystem.Service.Service.Enums.IColorService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl extends CRUDServiceImpl<Color, Integer> implements IColorService{

	@Autowired
	private IColorRepo repo;

	@Autowired
	private IColorMapper repoMapper;
	
	@Override
	protected JpaRepository<Color, Integer> getRepo() {
		return repo;
	}

	public boolean existsByIdentItem(ColorName nombreCateg){
		return repo.existsByIdentItem(nombreCateg);
	}

	public Color findByIdentItem(ColorName name){
		return  repo.findByIdentItem(name);
	}

	public List<ColorFilter> getColor(){
		return repoMapper.getColor();
	}

	public List<ColorFilter> listarColoresxID (int id){
		System.out.println(repoMapper.listarColoresxID(id));
		return repoMapper.listarColoresxID(id);
	}
}
