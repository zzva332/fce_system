package com.fce.system.inventarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements InventarioService  {

	@Autowired
	private InventarioRepositorio inventarioRepo;
	
	@Override
	public Inventario getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Inventario> item = inventarioRepo.findById(id);
		if(!item.isPresent()) return null;
		return item.get();
	}

	@Override
	public List<Inventario> getAll() {
		// TODO Auto-generated method stub
		return inventarioRepo.findAll();
	}

	@Override
	public Inventario update(Long id, Inventario request) {
		// TODO Auto-generated method stub
		Inventario item = getById(id);
		if(item == null) return null;
		
		item.setPorcentajeDescuento(request.getPorcentajeDescuento());
		item.setPorcentajeIva(request.getPorcentajeIva());
		item.setStock(request.getStock());
		item.setProducto(request.getProducto());
		
		inventarioRepo.save(item);
		
		return item;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		Inventario item = getById(id);
		if(item == null) return false;
		
		inventarioRepo.delete(item);
		return true;
	}

	@Override
	public Inventario create(Inventario request) {
		request.setId(null);
		inventarioRepo.save(request);
		return request;
	}

	
}
