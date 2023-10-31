package co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public final class ConsultarPorIdClienteUseCase implements UseCase<ClienteDomain>{

	
private DAOFactory factoria;
	
	public ConsultarPorIdClienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public final void execute(final ClienteDomain domain) {
		var entity = crearClienteEntityIdAConsultar(domain.getId());
	    var resultados = getClienteDAO().consultarPorId(entity.getId());
	    if (resultados.isEmpty()) {
	        String mensajeUsuario = "No existe el cliente con el identificar que se desea consultar";
	        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
	    }
	}
	private ClienteEntity crearClienteEntityIdAConsultar(final UUID id) {
	    var domain = ClienteDomain.crear(id, null, null, null, null, null, null);
	    return ClienteEntityMapper.convertToEntity(domain);
	}
	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO ();
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
