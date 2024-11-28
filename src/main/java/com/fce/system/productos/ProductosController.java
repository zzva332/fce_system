package com.fce.system.productos;

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

import com.fce.system.shared.Respuesta;
import com.fce.system.shared.Util;
import com.fce.system.shared.ValidateObject;

@RestController
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping()
	public Respuesta<List<Producto>> getAll(){
		return Util.CrearRespuesta(0, null, productoService.getAll());
	}
	@PostMapping()
	public Respuesta<Producto> create(@RequestBody Producto request) {
		//producto.id = null;
		
		List<String> errors = ValidateObject.validarProducto(request);
		if(errors.size() > 0) return Util.CrearRespuesta(errors);
		
		Producto productoResult = productoService.create(request);
		
		return Util.CrearRespuesta(0, "Se actualizo el registro", productoResult);
	}
	@PutMapping("/{id}")
	public Respuesta<Producto> update(@PathVariable("id") Long id, @RequestBody Producto request){
		
		if(id == null || id == 0) {
			return Util.CrearRespuesta(-1, "La propiedad {id} no puede ser vacia o 0", null);
		}
		
		List<String> errors = ValidateObject.validarProducto(request);
		if(errors.size() > 0) return Util.CrearRespuesta(errors);
		
			
		Producto item = productoService.update(id, request);
		
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
		
		var result = productoService.delete(id);
		
		if(!result) {
			return Util.CrearRespuesta(-1, "No se encontro el registro para eliminar. revise que exista" + id , null);
		}
		return Util.CrearRespuesta(0, "Registro removido exitosamente", null);
	}

}
