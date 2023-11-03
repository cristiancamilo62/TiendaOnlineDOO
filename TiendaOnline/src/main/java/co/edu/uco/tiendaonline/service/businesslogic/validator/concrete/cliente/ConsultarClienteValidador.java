package co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente;


import co.edu.uco.tiendaonline.service.businesslogic.validator.Validator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.ClienteValidationRule;

public final class ConsultarClienteValidador implements Validator<ClienteDomain>{

	
private static final Validator<ClienteDomain> instancia = new ConsultarClienteValidador();
	
	private ConsultarClienteValidador() {
		super();
	}
	
	public static final void ejecutarValidacion(final ClienteDomain data) {
		instancia.execute(data);
	}
	
	
	@Override
	public void execute(ClienteDomain dato) {
		ClienteValidationRule.ejecutarValidacion(dato);
		
	}

}
