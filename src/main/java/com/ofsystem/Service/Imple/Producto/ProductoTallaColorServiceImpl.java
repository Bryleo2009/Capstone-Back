package com.ofsystem.Service.Imple.Producto;

import com.ofsystem.Mapper.Filter.ColorTallaFilter;
import com.ofsystem.Mapper.IProductoMapper;
import com.ofsystem.Model.Enums.Color;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Producto.ProductoTallaColor;
import com.ofsystem.Model.Enums.Talla;
import com.ofsystem.Repo.Producto.IProductoTallaColorRepo;
import com.ofsystem.Service.Service.Producto.IProductoTallaColorService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoTallaColorServiceImpl extends CRUDServiceImpl<ProductoTallaColor, Integer> implements IProductoTallaColorService {

	@Autowired
	private IProductoTallaColorRepo repo;

	@Autowired
	private IProductoMapper maper;
	
	@Override
	protected JpaRepository<ProductoTallaColor, Integer> getRepo() {
		return repo;
	}

	@Override
	public ProductoTallaColor findByProductoAndTallaAndColor(Producto unProducto, Talla unaTalla, Color unColor) {
		return repo.findByProductoAndTallaAndColor(unProducto,unaTalla,unColor);
	}

	@Override
	public List<ColorTallaFilter> colorTalla(int idProduct) {
		return maper.colorTalla(idProduct);
	}


}
