package com.fce.system.shared;

import java.util.List;

public class Util {

	// Crea el objeto respuesta de cada controlador por codigo error, mensaje y data a mostrar
	// codigoError 0 - OK, -1 - ERROR
	public static <T> Respuesta<T>  CrearRespuesta(int codigoError, String mensaje, T data){
		Respuesta<T> respuesta = new Respuesta<T>();
		respuesta.codigoError = 0;
		if(codigoError != 0) respuesta.codigoError = codigoError;
		// solo vincula el mensaje si tiene uno a mostrar
		if(mensaje != null) respuesta.mensaje.add(mensaje);
		
		respuesta.data = data;
		
		return respuesta;
	}
	// crea el objeto respuesta de cada controlador por la lista de errores al validar el request
	public static <T> Respuesta<T>  CrearRespuesta(List<String> errors){
		Respuesta<T> respuesta = new Respuesta<T>();
		respuesta.codigoError = 0;
		if(errors.size() > 0) respuesta.codigoError = -1;
		respuesta.mensaje.addAll(errors);
		
		return respuesta;
	}
	// crea la respuesta solo con codigo error y data a mostrar
	public static <T> Respuesta<T>  CrearRespuesta(int codigoError, T data){
		Respuesta<T> respuesta = new Respuesta<T>();
		respuesta.codigoError = 0;
		if(codigoError != 0) respuesta.codigoError = codigoError;
		
		respuesta.data = data;
		
		return respuesta;
	}
}
