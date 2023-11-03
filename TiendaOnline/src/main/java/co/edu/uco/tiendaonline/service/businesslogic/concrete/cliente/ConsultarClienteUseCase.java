package co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente;


import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.service.businesslogic.UseCaseRetorno;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public final class ConsultarClienteUseCase implements UseCaseRetorno<ClienteDomain>{
	

	private DAOFactory factoria;
	
	public ConsultarClienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public Object executeRetorno(ClienteDomain domain) {
		var entity = ClienteEntityMapper.convertToEntity(domain);;
	    var resultados = getClienteDAO().consultar(entity);
	    if (resultados.isEmpty()) {
	        String mensajeUsuario = "No existe el cliente con el identificar que se desea consultar";
	        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
	    }
	    return resultados;
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
