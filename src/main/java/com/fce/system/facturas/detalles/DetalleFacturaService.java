package com.fce.system.facturas.detalles;

import java.util.List;

public interface DetalleFacturaService {

	public DetalleFactura getById(Long id);
	public List<DetalleFactura> getAll();
	public DetalleFactura update(Long id, DetalleFactura request);
	public Boolean delete(Long id);
	public DetalleFactura create(DetalleFactura request);
}
