package co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules;



import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class TipoIdentificacionValidationRule  implements ValidationRule<TipoIdentificacionDomain>{
	
	private static final ValidationRule<TipoIdentificacionDomain> instancia = new TipoIdentificacionValidationRule();
	
	private TipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(TipoIdentificacionDomain dato) {
		if(UtilObjeto.esNulo(null)) {
			var mensajeUsuario = "No es posible realizar la operacion con un tipo de identificación nulo";
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
}
}
