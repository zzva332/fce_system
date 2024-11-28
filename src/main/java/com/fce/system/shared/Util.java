package com.fce.system.shared;

import java.util.List;

public class Util {

	public static <T> Respuesta<T>  CrearRespuesta(int codigoError, String mensaje, T data){
		Respuesta<T> respuesta = new Respuesta<T>();
		respuesta.codigoError = 0;
		if(codigoError != 0) respuesta.codigoError = codigoError;
		respuesta.mensaje.add(mensaje);
		
		respuesta.data = data;
		
		return respuesta;
	}
	public static <T> Respuesta<T>  CrearRespuesta(List<String> errors){
		Respuesta<T> respuesta = new Respuesta<T>();
		respuesta.codigoError = 0;
		if(errors.size() > 0) respuesta.codigoError = -1;
		respuesta.mensaje.addAll(errors);
		
		return respuesta;
	}
	public static <T> Respuesta<T>  CrearRespuesta(int codigoError, T data){
		Respuesta<T> respuesta = new Respuesta<T>();
		respuesta.codigoError = 0;
		if(codigoError != 0) respuesta.codigoError = codigoError;
		
		respuesta.data = data;
		
		return respuesta;
	}
}
