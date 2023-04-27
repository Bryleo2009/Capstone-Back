package com.ofsystem.Service.Imple;

import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Model.Categoria;
import com.ofsystem.Repo.ICategoriaRepo;
import com.ofsystem.Service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl extends CRUDServiceImpl<Categoria, Integer> implements ICategoriaService{

	@Autowired
	private ICategoriaRepo repo;
	
	@Override
	protected JpaRepository<Categoria, Integer> getRepo() {
		return repo;
	}

	public boolean existsByNombreCateg(CategoriaName nombreCateg){
		return repo.existsByIdentItem(nombreCateg);
	}

	public Categoria findByNombreCateg(CategoriaName name){
		return  repo.findByIdentItem(name);
	}
}
