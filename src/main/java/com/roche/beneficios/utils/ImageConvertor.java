package com.roche.beneficios.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component("imageConvertor")
public class ImageConvertor {
	
	public String convertToBase64(byte[] imageBinary) {
		// Conversion de Bytes para mostrar en la vista la imagen de la empresa
	    byte[] encoded= Base64.encodeBase64(imageBinary);
	    
	    return new String(encoded);
	}
}
