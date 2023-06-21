package com.ofsystem.Capstone.Service.Imple.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.CategoriaName;
import com.ofsystem.Capstone.Model.Enums.Categoria;
import com.ofsystem.Capstone.Repo.Enums.ICategoriaRepo;
import com.ofsystem.Capstone.Service.Service.Enums.ICategoriaService;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
