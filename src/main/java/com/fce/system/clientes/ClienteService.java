package com.fce.system.clientes;

import java.util.List;

public interface ClienteService {

	public Cliente getById(Long id);
	public List<Cliente> getAll();
	public Cliente update(Long id, Cliente request);
	public Boolean delete(Long id);
	public Cliente create(Cliente request);
}
