package com.roche.beneficios.exceptions;

public class BusquedaNulaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BusquedaNulaException () {
		super("Lo sentimos, no tenemos registros que coincidan");
	}

}
