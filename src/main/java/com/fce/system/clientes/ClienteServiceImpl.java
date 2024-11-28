package com.fce.system.clientes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService  {

	@Autowired
	private ClienteRepositorio productoRepo;
	
	@Override
	public Cliente getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> item = productoRepo.findById(id);
		if(!item.isPresent()) return null;
		return item.get();
	}

	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return productoRepo.findAll();
	}

	@Override
	public Cliente update(Long id, Cliente request) {
		// TODO Auto-generated method stub
		Cliente item = getById(id);
		if(item == null) return null;
		
		item.setNombre(request.getNombre());
		item.setEmail(request.getEmail());
		item.setTipoDocumento(request.getTipoDocumento());
		item.setDocumento(request.getDocumento());
		
		productoRepo.save(item);
		
		return item;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		Cliente item = getById(id);
		if(item == null) return false;
		
		productoRepo.delete(item);
		return true;
	}

	@Override
	public Cliente create(Cliente request) {
		request.setId(null);
		productoRepo.save(request);
		return request;
	}

	
}
