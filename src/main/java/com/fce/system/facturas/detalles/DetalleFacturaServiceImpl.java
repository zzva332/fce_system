package com.fce.system.facturas.detalles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fce.system.clientes.ClienteRepositorio;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService  {

	@Autowired
	private DetalleFacturaRepositorio detalleFacturaRepo;
	
	@Override
	public DetalleFactura getById(Long id) {
		// TODO Auto-generated method stub
		Optional<DetalleFactura> item = detalleFacturaRepo.findById(id);
		if(!item.isPresent()) return null;
		return item.get();
	}

	@Override
	public List<DetalleFactura> getAll() {
		// TODO Auto-generated method stub
		return detalleFacturaRepo.findAll();
	}

	@Override
	public DetalleFactura update(Long id, DetalleFactura request) {
		// TODO Auto-generated method stub
		DetalleFactura item = getById(id);
		if(item == null) return null;
		
		detalleFacturaRepo.save(item);
		
		return item;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		DetalleFactura item = getById(id);
		if(item == null) return false;
		
		detalleFacturaRepo.delete(item);
		return true;
	}

	@Override
	public DetalleFactura create(DetalleFactura request) {
		request.setId(null);
		
		detalleFacturaRepo.save(request);
		return request;
	}

	
}
