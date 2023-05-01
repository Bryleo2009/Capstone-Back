package com.ofsystem.Service.Imple;

import com.ofsystem.Mapper.Filter.ProductoFilter;
import com.ofsystem.Mapper.IProductoMapper;
import com.ofsystem.Model.Producto;
import com.ofsystem.Repo.IProductoRepo;
import com.ofsystem.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl extends CRUDServiceImpl<Producto, Integer> implements IProductoService{

	@Autowired
	private IProductoRepo repo;

	@Autowired
	private IProductoMapper repoMapper;
	
	@Override
	protected JpaRepository<Producto, Integer> getRepo() {
		return repo;
	}

	public Page<Producto> listarPaginado(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return repo.findAll(pageable);
	}

	public boolean existsByNombre(String name){
		return repo.existsByNombreProduct(name);
	}


	public Page<ProductoFilter> busquedaFiltrada(String categoria, String[] tipos, String[] etiquetas, String[] tallas, String[] marcas, String[] colores,double menorPrecio, double mayorPrecio, int cantidad, int pagina) {

		PageRequest pageRequest = PageRequest.of(pagina, cantidad);
		System.out.println("****de BACK*****");
		System.out.println("tipos '"+String.join("', '", tipos)+"'");
		System.out.println("etiquetas '"+String.join("', '", etiquetas)+"'");
		System.out.println("tallas '"+String.join("', '", tallas)+"'");
		System.out.println("marcas '"+String.join("', '", marcas)+"'");
		System.out.println("marcas '"+String.join("', '", colores)+"'");
		List<ProductoFilter> lista = repoMapper.busquedaFiltrada("'"+categoria+"'", "'"+String.join("', '", tipos)+"'","'"+String.join("', '", etiquetas)+"'" , "'" + String.join("', '", tallas) + "'", "'"+String.join("', '", marcas)+"'", "'"+String.join("', '", colores)+"'",menorPrecio, mayorPrecio, cantidad, pagina);
		return new PageImpl<>(lista, pageRequest, repo.findAll().size());
	}

	public Producto listarxIUP (String iup){
		return repoMapper.listarxIUP(iup);
	}
}
