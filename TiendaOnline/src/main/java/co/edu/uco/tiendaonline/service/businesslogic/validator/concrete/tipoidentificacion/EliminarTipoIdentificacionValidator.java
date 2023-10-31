package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;

public final class EliminarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{

	private static final Validator<TipoIdentificacionDomain> instancia = new EliminarTipoIdentificacionValidator();
	
	private EliminarTipoIdentificacionValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain data) {
		instancia.execute(data);
	}

	@Override
	public final void execute(final TipoIdentificacionDomain data) {
		TipoIdentificacionValidationRule.ejecutarValidacion(data);
		IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getId());
		
	}
	
}
