package com.fce.system.shared;

import java.util.ArrayList;
import java.util.List;

/// clase modelo para devolver un estandar en las respuestas para todos
public class Respuesta<T> {
	public int codigoError;
	public List<String> mensaje;
	public T data;
	
	Respuesta(){
		mensaje = new ArrayList<String>();
	}
}

