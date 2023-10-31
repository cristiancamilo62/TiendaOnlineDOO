package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoClienteDomain;

public final class NumeroTelefonoClienteValidationRule implements ValidationRule<NumeroTelefonoClienteDomain>{
	
	private static final ValidationRule<NumeroTelefonoClienteDomain> instancia = new NumeroTelefonoClienteValidationRule();
	
	private NumeroTelefonoClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NumeroTelefonoClienteDomain dato) {
		instancia.validar(dato);
	}


	@Override
	public final void validar(final NumeroTelefonoClienteDomain dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}

	private final void validarFormato(final NumeroTelefonoClienteDomain dato) {
		if(!UtilTexto.contieneSoloDigitos(dato.getNumeroTelefono())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000064);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarObligatoriedad(final NumeroTelefonoClienteDomain dato) {
		if(UtilObjeto.esNulo(dato.getNumeroTelefono())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000065);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarLongitud(final NumeroTelefonoClienteDomain dato) {
		if(!UtilTexto.longitudValida(dato.getNumeroTelefono(), 10, 10)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000066);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

}
