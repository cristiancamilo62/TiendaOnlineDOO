package co.edu.uco.tiendaonline.service.facade.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion.ModificarTipoIdentificacionUseCase;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.facade.Facade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public final class ModificarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO>{

	@Override
	public final void execute(final TipoIdentificacionDTO dto) {
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto);
		TipoIdentificacionValidationRule.ejecutarValidacion(domain);
		
		final DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new ModificarTipoIdentificacionUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransacion();
		} catch (final TiendaOnlineException exception) {
			daoFactory.cancelarTransacion();
			throw exception;
		}catch (final Exception exception) {
			daoFactory.cancelarTransacion();
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000114);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000115);
			throw ServiceTiendaOnlineException.crear(exception, mensajeUsuario,mensajeTecnico);
		}
		finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
