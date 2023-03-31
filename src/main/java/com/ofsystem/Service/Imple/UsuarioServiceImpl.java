package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Usuario;
import com.ofsystem.Repo.IUsuarioRepo;
import com.ofsystem.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CRUDServiceImpl<Usuario, Integer> implements IUsuarioService{

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected JpaRepository<Usuario, Integer> getRepo() {
		return repo;
	}

}
