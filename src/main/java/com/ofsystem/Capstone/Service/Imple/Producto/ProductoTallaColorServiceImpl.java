package com.ofsystem.Capstone.Service.Imple.Producto;

import com.ofsystem.Capstone.Model.Producto.Producto;
import com.ofsystem.Capstone.Model.Producto.ProductoTallaColor;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Service.Service.Producto.IProductoTallaColorService;
import com.ofsystem.Capstone.Model.Enums.Color;
import com.ofsystem.Capstone.Model.Enums.Talla;
import com.ofsystem.Capstone.Repo.Producto.IProductoTallaColorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoTallaColorServiceImpl extends CRUDServiceImpl<ProductoTallaColor, Integer> implements IProductoTallaColorService {

	@Autowired
	private IProductoTallaColorRepo repo;
	
	@Override
	protected JpaRepository<ProductoTallaColor, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Talla> talla(Producto unProducto) {
		return repo.tallas(unProducto);
	}

	@Override
	public List<Color> colores(Producto unProducto) {
		return repo.colores(unProducto);
	}

	@Override
	public ProductoTallaColor findByProducto_IdProductAndColorAndTalla(int idProducto, Color color, Talla talla) {
		return repo.findByProducto_IdProductAndColorAndTalla(idProducto,color,talla);
	}
}
