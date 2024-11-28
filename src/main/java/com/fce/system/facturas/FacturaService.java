package com.fce.system.facturas;

import java.util.List;

public interface FacturaService {

	public Factura getById(Long id);
	public List<Factura> getAll();
	public Factura update(Long id, Factura request);
	public Boolean delete(Long id);
	public Factura create(Factura request);
}
