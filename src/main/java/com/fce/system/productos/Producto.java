package com.fce.system.productos;

import java.math.BigDecimal;
import java.util.List;

import com.fce.system.facturas.detalles.DetalleFactura;
import com.fce.system.shared.ValidateObject;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String nombre;
	private String descripcion;
	@Column(columnDefinition = "DECIMAL(10,2)")
	private BigDecimal precio;

}
