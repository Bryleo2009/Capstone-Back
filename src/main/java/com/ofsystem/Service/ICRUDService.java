package com.ofsystem.Service;

import java.util.List;

public interface ICRUDService<T, ID> {

	T registrar(T t);
	T modificar(T t);
	T listarxID(ID id);
	List<T> listar();
	void eliminar(ID id);
}
