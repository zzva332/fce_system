package com.fce.system.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fce.system.clientes.Cliente;
import com.fce.system.productos.Producto;

public class ValidateObject {
	public static List<String> validarProducto(Producto request){
		List<String> errors = new ArrayList<String>();
		if(request.getCodigo() == null || request.getCodigo().isBlank()) errors.add("propiedad codigo requerida");
		if(request.getDescripcion() == null || request.getDescripcion().isBlank()) errors.add("propiedad descripcion requerida");
		if(request.getNombre() == null || request.getNombre().isBlank()) errors.add("propiedad nombre requerida");
		
		if(request.getPrecio() == null) errors.add("propiedad precio es requerida");
		else if(request.getPrecio().doubleValue() <= 0) errors.add("propiedad precio debe ser mayor a 0");
		return errors;
	}
	public static List<String> validarCliente(Cliente request){
		List<String> errors = new ArrayList<String>();
		if(request.getNombre() == null || request.getNombre().isBlank()) errors.add("propiedad nombre requerida");
		if(request.getEmail() == null || request.getEmail().isBlank()) errors.add("propiedad email requerida");
		
		List<String> lista = Arrays.asList("CC","TI","CE");
		if(request.getTipoDocumento() == null || request.getTipoDocumento().trim().isBlank()) errors.add("propiedad nombre requerida");
		else if(!lista.contains(request.getTipoDocumento().trim().toUpperCase())) {
			errors.add("propiedad tipoDocumento solo acepta CC, TI, CE");
		}
		if(request.getDocumento() == null || request.getDocumento().isEmpty()) errors.add("propiedad documento es requerida");
		
		return errors;
	}
}
