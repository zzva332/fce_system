package com.fce.system.facturas.detalles;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura, Long> {

}
