package com.fce.system.inventarios;

import java.time.LocalDateTime;
import com.fce.system.productos.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int Stock;
	private LocalDateTime fecha;
	@Column(name = "porcentaje_descuento", columnDefinition = "DECIMAL(5,2)")
	private double porcentajeDescuento;
	@Column(name = "porcentaje_iva", columnDefinition = "DECIMAL(5,2)")
	private double porcentajeIva;
	
	@OneToOne()
	@JoinColumn(name = "producto_id")
	private Producto producto;
}
