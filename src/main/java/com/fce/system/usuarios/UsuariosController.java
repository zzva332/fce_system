package com.fce.system.usuarios;

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
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping()
	public Respuesta<List<Usuario>> getAll(){
		return Util.CrearRespuesta(0, null, usuarioService.getAll());
	}
	@PostMapping()
	public Respuesta<Usuario> create(@RequestBody Usuario request) {
		//producto.id = null;
		
		Usuario productoResult = usuarioService.create(request);
		
		return Util.CrearRespuesta(0, "Se actualizo el registro", productoResult);
	}
	@PutMapping("/{id}")
	public Respuesta<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario request){
		
		Usuario item = usuarioService.update(id, request);
		
		if(item == null) {
			return Util.CrearRespuesta(-1, "No se encontro el registro con id " + id , null);
		}
		return Util.CrearRespuesta(0, "Registro actualizado", item);
	}
}
