package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.ColorName;
import com.ofsystem.Mapper.Filter.ColorFilter;
import com.ofsystem.Mapper.IColorMapper;
import com.ofsystem.Model.Color;
import com.ofsystem.Repo.IColorRepo;
import com.ofsystem.Service.IColorService;
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
}
