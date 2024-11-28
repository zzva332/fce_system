package com.fce.system.productos;

import java.util.List;

public interface ProductoService {

	public Producto getById(Long id);
	public List<Producto> getAll();
	public Producto update(Long id, Producto request);
	public Boolean delete(Long id);
	public Producto create(Producto request);
}
