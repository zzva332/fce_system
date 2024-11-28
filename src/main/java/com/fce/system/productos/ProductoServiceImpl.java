package com.fce.system.productos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService  {

	@Autowired
	private ProductoRepositorio productoRepo;
	
	@Override
	public Producto getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Producto> item = productoRepo.findById(id);
		if(!item.isPresent()) return null;
		return item.get();
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return productoRepo.findAll();
	}

	@Override
	public Producto update(Long id, Producto request) {
		// TODO Auto-generated method stub
		Producto item = getById(id);
		if(item == null) return null;
		
		item.setCodigo(request.getCodigo());
		item.setNombre(request.getNombre());
		item.setDescripcion(request.getDescripcion());
		item.setPrecio(request.getPrecio());
		
		productoRepo.save(item);
		
		return item;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		Producto item = getById(id);
		if(item == null) return false;
		
		productoRepo.delete(item);
		return true;
	}

	@Override
	public Producto create(Producto request) {
		request.setId(null);
		productoRepo.save(request);
		return request;
	}

	
}
