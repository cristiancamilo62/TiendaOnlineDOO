package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUuid;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;

public final class IdTipoIdentificacionValidationRule  implements ValidationRule<UUID>{
	
	private static final ValidationRule<UUID> instancia = new IdTipoIdentificacionValidationRule();
	
	private IdTipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(UUID dato) {
		validarObligatoriedad(dato);
		validarIdPorDefecto(dato);
		
	}
	
	private final void validarObligatoriedad(final UUID id) {
		if(UtilObjeto.esNulo(id)) {
			var mensajeUsuario = "El id del tipo de identificación es un dato obligatorio";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
			
	}
	
	private final void validarIdPorDefecto(final UUID id) {
		if(UtilUuid.valorDefecto(id)) {
			var mensajeUsuario = "El id del tipo de identificacion es el valor por defecto";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	

}
