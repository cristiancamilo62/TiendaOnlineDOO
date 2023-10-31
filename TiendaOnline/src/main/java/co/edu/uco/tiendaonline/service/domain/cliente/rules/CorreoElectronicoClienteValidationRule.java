package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;

public final class CorreoElectronicoClienteValidationRule implements ValidationRule<CorreoElectronicoClienteDomain> {
	
	private static final ValidationRule<CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoClienteValidationRule();
	
	private   CorreoElectronicoClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final CorreoElectronicoClienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public final void validar(final CorreoElectronicoClienteDomain dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	private final void validarLongitud(final CorreoElectronicoClienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getCorreoElectronico(), 40)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000046);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final CorreoElectronicoClienteDomain dato) {
		if(UtilTexto.estaVacio(dato.getCorreoElectronico())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000047);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final CorreoElectronicoClienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosArrobaDominio(dato.getCorreoElectronico())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000048);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}

}
