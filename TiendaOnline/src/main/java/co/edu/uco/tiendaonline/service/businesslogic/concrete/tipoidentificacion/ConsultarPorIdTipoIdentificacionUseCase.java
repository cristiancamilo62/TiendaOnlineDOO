package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class ConsultarPorIdTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain>{

	
private DAOFactory factoria;
	
	public ConsultarPorIdTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(final TipoIdentificacionDomain domain) {
		var entity = crearTipoIdentificacionEntityIdAConsultar(domain.getId());
	    var resultados = getTipoIdentificacionDAO().consultarPorId(entity.getId());
	    if (resultados.isEmpty()) {
	        String mensajeUsuario = "No existe el tipo de identificacion con el identificar que se desea consultar";
	        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
	    }
	}
	private TipoIdentificacionEntity crearTipoIdentificacionEntityIdAConsultar(final UUID id) {
	    var domain = TipoIdentificacionDomain.crear(id, null, null, false);
	    return TipoIdentificacionEntityMapper.convertToEntity(domain);
	}

	
	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final TipoIdentificacionDAO getTipoIdentificacionDAO () {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}

	private final void setFactoria(DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000112);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000113);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	

}
