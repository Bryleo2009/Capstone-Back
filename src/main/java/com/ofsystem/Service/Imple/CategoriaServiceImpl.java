package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Categoria;
import com.ofsystem.Repo.ICategoriaRepo;
import com.ofsystem.Service.ICategoriaService;
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

}
