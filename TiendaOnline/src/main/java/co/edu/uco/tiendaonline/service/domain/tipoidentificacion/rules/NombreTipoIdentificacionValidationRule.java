package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public final class NombreTipoIdentificacionValidationRule implements ValidationRule<String>{

	private static final ValidationRule<String> instancia = new NombreTipoIdentificacionValidationRule();
	
	private NombreTipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}
	
	@Override
	public final void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato,10)) {
			var mensajeUsuario = "La longitud del Nombre del tipo de identificacion no en valida.La longitud maxima es 100 caracteres";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "El Nombre del tipo de identificacion es oblgatorio";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
		
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) {
			var mensajeUsuario = "El Nombre del tipo de identificación solo debe contener letras, digitos y espacios";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}
}

