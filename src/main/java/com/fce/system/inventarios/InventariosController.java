package com.fce.system.inventarios;

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
@RequestMapping("/inventarios")
public class InventariosController {

	@Autowired
	private InventarioService clienteService;
	
	@GetMapping()
	public Respuesta<List<Inventario>> getAll(){
		return Util.CrearRespuesta(0, null, clienteService.getAll());
	}
	@PostMapping()
	public Respuesta<Inventario> create(@RequestBody Inventario request) {
		//producto.id = null;
		
		Inventario productoResult = clienteService.create(request);
		
		return Util.CrearRespuesta(0, "Se actualizo el registro", productoResult);
	}
	@PutMapping("/{id}")
	public Respuesta<Inventario> update(@PathVariable("id") Long id, @RequestBody Inventario request){
		
		Inventario item = clienteService.update(id, request);
		
		if(item == null) {
			return Util.CrearRespuesta(-1, "No se encontro el registro con id " + id , null);
		}
		return Util.CrearRespuesta(0, "Registro actualizado", item);
	}
}
