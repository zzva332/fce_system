package com.fce.system.facturas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fce.system.shared.Respuesta;
import com.fce.system.shared.Util;

@RestController
@RequestMapping("/facturas")
public class FacturasController {

	@Autowired
	private FacturaService facturaService;
	
	@GetMapping()
	public Respuesta<List<Factura>> getAll(){
		return Util.CrearRespuesta(0, null, facturaService.getAll());
	}
	@PostMapping()
	public Respuesta<Factura> create(@RequestBody Factura request) {
		//producto.id = null;
		
		Factura productoResult = facturaService.create(request);
		
		return Util.CrearRespuesta(0, "Se actualizo el registro", productoResult);
	}
	@PutMapping("/{id}")
	public Respuesta<Factura> update(@PathVariable("id") Long id, @RequestBody Factura request){
		
		Factura item = facturaService.update(id, request);
		
		if(item == null) {
			return Util.CrearRespuesta(-1, "No se encontro el registro con id " + id , null);
		}
		return Util.CrearRespuesta(0, "Registro actualizado", item);
	}
}
