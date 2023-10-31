package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente;

import java.util.UUID;

import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.IdClienteValidationRule;

public final class ConsultarPorIdClienteValidador implements Validator<UUID> {


	private static final Validator<UUID> instancia = new ConsultarPorIdClienteValidador();
	
	private ConsultarPorIdClienteValidador() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(UUID dato) {
		IdClienteValidationRule.ejecutarValidacion(dato);
		
	}

}
