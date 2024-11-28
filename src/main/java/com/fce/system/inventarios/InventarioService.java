package com.fce.system.inventarios;

import java.util.List;

public interface InventarioService {

	public Inventario getById(Long id);
	public List<Inventario> getAll();
	public Inventario update(Long id, Inventario request);
	public Boolean delete(Long id);
	public Inventario create(Inventario request);
}
