package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.ClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.CorreoElectronicoClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.FechaNacimientoClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.NombreCompletoClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.NumeroIdentificacionClienteValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.NumeroTelefonoClienteValidationRule;

public final class ModificarClienteValidator implements Validator<ClienteDomain>{

	

	private static final Validator<ClienteDomain> instancia = new ModificarClienteValidator();
	
	private  ModificarClienteValidator() {
		super();
	}
	
	public static final void ejecutarValidacion(final ClienteDomain data) {
		instancia.execute(data);
	}

	@Override
	public final void execute(final ClienteDomain data) {
		ClienteValidationRule.ejecutarValidacion(data);
		NumeroIdentificacionClienteValidationRule.ejecutarValidacion(data.getIdentificacion());
		NombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto());
		CorreoElectronicoClienteValidationRule.ejecutarValidacion(data.getCorreoElectronico());
		NumeroTelefonoClienteValidationRule.ejecutarValidacion(data.getNumeroTelefono());
		FechaNacimientoClienteValidationRule.ejecutarValidacion(data.getFechaNacimiento());
	}

}
