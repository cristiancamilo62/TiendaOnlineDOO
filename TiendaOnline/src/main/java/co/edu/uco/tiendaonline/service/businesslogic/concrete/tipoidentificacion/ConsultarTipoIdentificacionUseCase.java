
package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.UseCaseRetorno;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class ConsultarTipoIdentificacionUseCase implements UseCaseRetorno<TipoIdentificacionDomain>{

	private DAOFactory factoria;
	
	public ConsultarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public Object executeRetorno(TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
	    var resultados = getTipoIdentificacionDAO().consultar(entity);
	    if (resultados.isEmpty()) {
	        String mensajeUsuario = "No existe el tipo de identificacion con el identificar que se desea consultar";
	        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
	    }
	    return resultados;	
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
