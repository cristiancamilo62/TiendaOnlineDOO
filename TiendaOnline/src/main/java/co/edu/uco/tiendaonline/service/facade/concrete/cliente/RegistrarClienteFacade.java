package co.edu.uco.tiendaonline.service.facade.concrete.cliente;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente.RegistrarClienteUseCase;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.rules.ClienteValidationRule;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.facade.Facade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.ClienteDTOMapper;

public final class RegistrarClienteFacade implements Facade<ClienteDTO>{

	@Override
	public final void execute(final ClienteDTO dto) {

		final ClienteDomain domain = ClienteDTOMapper.convertToDomain(dto);
		ClienteValidationRule.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarClienteUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransacion();
		} catch (final TiendaOnlineException exception) {
			daoFactory.cancelarTransacion();
			throw exception;
		}catch (final Exception exception) {
			daoFactory.cancelarTransacion();
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000120);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000121);
			throw ServiceTiendaOnlineException.crear(exception, mensajeUsuario,mensajeTecnico);
		}
		finally {
			daoFactory.cerrarConexion();
		}
		
	}

	
}
