package com.fce.system.facturas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fce.system.clientes.Cliente;
import com.fce.system.clientes.ClienteRepositorio;

@Service
public class FacturaServiceImpl implements FacturaService  {

	@Autowired
	private FacturaRepositorio facturaRepo;
	@Autowired
	private ClienteRepositorio clienteRepo;
	
	@Override
	public Factura getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Factura> item = facturaRepo.findById(id);
		if(!item.isPresent()) return null;
		return item.get();
	}

	@Override
	public List<Factura> getAll() {
		// TODO Auto-generated method stub
		return facturaRepo.findAll();
	}

	@Override
	public Factura update(Long id, Factura request) {
		// TODO Auto-generated method stub
		Factura item = getById(id);
		if(item == null) return null;
		
		Cliente cliente = clienteRepo.findById(request.getCliente().getId()).orElseThrow();
		
		item.setCliente(cliente);
		
		facturaRepo.save(item);
		
		//item.setDetallesFactura(null);
		item.setCliente(null);
		
		return item;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		Factura item = getById(id);
		if(item == null) return false;
		
		facturaRepo.delete(item);
		return true;
	}

	@Override
	public Factura create(Factura request) {
		request.setId(null);
		
		Cliente cliente = clienteRepo.findById(request.getCliente().getId()).orElseThrow();
		
		request.setCliente(cliente);
		
		facturaRepo.save(request);
		return request;
	}

	
}
