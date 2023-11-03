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

public final class EliminarClienteUseCase implements UseCase<ClienteDomain> {

	private DAOFactory factoria;
	
	public EliminarClienteUseCase(final DAOFactory factoria) {
		setFactory(factoria);
	}
	
	@Override
	public void execute(ClienteDomain domain) {
		
		validarExistenciaClienteAEliminar(domain.getId());
		
		eliminarCliente(domain);
		
	}
	
	private void eliminarCliente(final ClienteDomain domain) {
		var entity = ClienteEntityMapper.convertToEntity(domain);
		getClienteDAO().eliminar(entity.getId());
	}

	private final void validarExistenciaClienteAEliminar(final UUID id) {
	    var entity = crearClienteEntityIdAEliminar(id);
	    var resultados = getClienteDAO().consultarPorId(entity.getId());
	    if (resultados.isEmpty()) {
	        String mensajeUsuario = "No existe el cliente que se desea eliminar";
	        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
	    }
	}

	private ClienteEntity crearClienteEntityIdAEliminar(final UUID id) {
	    var domain = ClienteDomain.crear(id, null, null, null, null, null, null);
	    return ClienteEntityMapper.convertToEntity(domain);
	}
	public final DAOFactory getFactoria() {
		return factoria;
	}
	

	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}

	public final void setFactory(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000117);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000118);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}

	
	

}
