package com.ofsystem.Service.Imple.Enums;

import com.ofsystem.Model.Enums.Name.EstPedidoName;
import com.ofsystem.Model.Enums.EstPedido;
import com.ofsystem.Repo.Enums.IEstPedidoRepo;
import com.ofsystem.Service.Service.Enums.IEstPedidoService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstPedidoServiceImpl extends CRUDServiceImpl<EstPedido, Integer> implements IEstPedidoService {

	@Autowired
	private IEstPedidoRepo repo;
	
	@Override
	protected JpaRepository<EstPedido, Integer> getRepo() {
		return repo;
	}

	public boolean existsByNombreCateg(EstPedidoName nombreCateg){
		return repo.existsByIdentItem(nombreCateg);
	}

	public EstPedido findByNombreCateg(EstPedidoName name){
		return  repo.findByIdentItem(name);
	}
}
