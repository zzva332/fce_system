package com.fce.system.shared;

import java.util.ArrayList;
import java.util.List;

public class Respuesta<T> {
	public int codigoError;
	public List<String> mensaje;
	public T data;
	
	Respuesta(){
		mensaje = new ArrayList<String>();
	}
}

