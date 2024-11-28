package com.fce.system.clientes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fce.system.productos.Producto;
import com.fce.system.shared.Respuesta;
import com.fce.system.shared.Util;
import com.fce.system.shared.ValidateObject;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping()
	public Respuesta<List<Cliente>> getAll(){
		return Util.CrearRespuesta(0, null, clienteService.getAll());
	}
	@PostMapping()
	public Respuesta<Cliente> create(@RequestBody Cliente request) {
		
		// validar el objeto request a que cumpla con las validaciones
		List<String> errors = ValidateObject.validarCliente(request);
		if(errors.size() > 0) return Util.CrearRespuesta(errors);
		
		Cliente productoResult = clienteService.create(request);
		
		return Util.CrearRespuesta(0, "Se actualizo el registro", productoResult);
	}
	@PutMapping("/{id}")
	public Respuesta<Cliente> update(@PathVariable("id") Long id, @RequestBody Cliente request){
		
		if(id == null || id == 0) {
			return Util.CrearRespuesta(-1, "La propiedad {id} no puede ser vacia o 0", null);
		}
		
		List<String> errors = ValidateObject.validarCliente(request);
		if(errors.size() > 0) return Util.CrearRespuesta(errors);
		
		Cliente item = clienteService.update(id, request);
		
		if(item == null) {
			return Util.CrearRespuesta(-1, "No se encontro el registro con id " + id , null);
		}
		return Util.CrearRespuesta(0, "Registro actualizado", item);
	}
	@DeleteMapping("/{id}")
	public Respuesta<Producto> delete(@PathVariable("id") Long id){
		
		if(id == null || id == 0) {
			return Util.CrearRespuesta(-1, "La propiedad {id} no puede ser vacia o 0", null);
		}
		
		var result = clienteService.delete(id);
		
		if(!result) {
			return Util.CrearRespuesta(-1, "No se encontro el registro para eliminar. revise que exista" + id , null);
		}
		return Util.CrearRespuesta(0, "Registro removido exitosamente", null);
	}
}
