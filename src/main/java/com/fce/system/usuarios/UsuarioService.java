package com.fce.system.usuarios;

import java.util.List;

public interface UsuarioService {

	public Usuario getById(Long id);
	public List<Usuario> getAll();
	public Usuario update(Long id, Usuario request);
	public Boolean delete(Long id);
	public Usuario create(Usuario request);
}
