package com.ofsystem.Capstone.Service.Imple.Enums;

import com.ofsystem.Capstone.Mapper.Filter.ColorFilter;
import com.ofsystem.Capstone.Mapper.IColorMapper;
import com.ofsystem.Capstone.Model.Enums.Name.ColorName;
import com.ofsystem.Capstone.Model.Enums.Color;
import com.ofsystem.Capstone.Repo.Enums.IColorRepo;
import com.ofsystem.Capstone.Service.Service.Enums.IColorService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
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
