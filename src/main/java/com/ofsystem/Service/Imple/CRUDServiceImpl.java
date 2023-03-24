package com.ofsystem.Service.Imple;

import com.ofsystem.Service.ICRUDService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class CRUDServiceImpl<T, ID> implements ICRUDService<T,ID>{

protected abstract JpaRepository<T, ID> getRepo();
	
	@Override
	public T registrar(T t) {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) {
		return getRepo().save(t);
	}

	@Override
	public T listarxID(ID id) {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public List<T> listar() {
		return (List<T>) getRepo().findAll();
	}

	@Override
	public void eliminar(ID id) {
		getRepo().deleteById(id);
	}
}
