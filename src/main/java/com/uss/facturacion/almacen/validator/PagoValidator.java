package com.uss.facturacion.almacen.validator;

import com.uss.facturacion.almacen.entity.Pago;
import com.uss.facturacion.almacen.exception.ValidateServiceException;

public class PagoValidator {
	public static void save (Pago pago) {
		if(pago.getDocumentoInquilino()==null || pago.getDocumentoInquilino().trim().isEmpty()) {
			throw new ValidateServiceException("El documento del inquilino es requerido");
		}
		if(pago.getDocumentoInquilino().length()>15) {
			throw new ValidateServiceException("El documento del inquilino es muy extenso");
		}
	}

}
