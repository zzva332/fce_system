package com.fce.system.facturas.detalles;

import java.math.BigDecimal;
import com.fce.system.facturas.Factura;
import com.fce.system.productos.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int cantidad;
	@Column(name = "valor_bruto", columnDefinition = "DECIMAL(10,2)")
	private BigDecimal valorBruto;
	@Column(name = "valor_neto", columnDefinition = "DECIMAL(10,2)")
	private BigDecimal valorNeto;
	@Column(name = "valor_iva", columnDefinition = "DECIMAL(5,2)")
	private BigDecimal valorIva;
	@Column(name = "valor_descuento", columnDefinition = "DECIMAL(8,2)")
	private BigDecimal valorDescuento;
	
	@ManyToOne
	@JoinColumn(name="factura_id")
	private Factura factura;
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Producto producto;
}
