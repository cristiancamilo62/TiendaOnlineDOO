package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;

import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;

public final class ConsultarPorIdTipoIdentificacionValidator implements Validator<UUID>{

	
	private static final Validator<UUID> instancia = new ConsultarPorIdTipoIdentificacionValidator();
	
	private ConsultarPorIdTipoIdentificacionValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID data) {
		instancia.execute(data);
	}

	
	@Override
	public final void execute(final UUID dato) {
		IdTipoIdentificacionValidationRule.ejecutarValidacion(dato);
		
	}

}
