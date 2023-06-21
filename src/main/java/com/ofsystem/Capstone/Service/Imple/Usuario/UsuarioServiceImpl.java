package com.ofsystem.Capstone.Service.Imple.Usuario;

import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Service.Service.Usuario.IUsuarioService;
import com.ofsystem.Capstone.Model.Usuario.Usuario;
import com.ofsystem.Capstone.Repo.Usuario.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CRUDServiceImpl<Usuario, Integer> implements IUsuarioService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected JpaRepository<Usuario, Integer> getRepo() {
		return repo;
	}

	@Override
	public Usuario findByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public boolean existsByUsername(String username) {
		return repo.existsByUsername(username);
	}

}
