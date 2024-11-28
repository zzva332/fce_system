package com.fce.system.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService  {

	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> item = usuarioRepo.findById(id);
		if(!item.isPresent()) return null;
		return item.get();
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario update(Long id, Usuario request) {
		// TODO Auto-generated method stub
		Usuario item = getById(id);
		if(item == null) return null;
		
		item.setNombre(request.getNombre());
		item.setEmail(request.getEmail());
		item.setPassword(request.getPassword());
		
		usuarioRepo.save(item);
		
		return item;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		Usuario item = getById(id);
		if(item == null) return false;
		
		usuarioRepo.delete(item);
		return true;
	}

	@Override
	public Usuario create(Usuario request) {
		request.setId(null);
		usuarioRepo.save(request);
		return request;
	}

	
}
