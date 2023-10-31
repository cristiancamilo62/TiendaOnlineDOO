package co.edu.uco.tiendaonline.service.businesslogic.concrete.cliente;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.cliente.RegistrarClienteValidator;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public final class RegistrarClienteUseCase implements UseCase<ClienteDomain>{

	private DAOFactory factoria;
	
	public RegistrarClienteUseCase(final DAOFactory factoria) {
		setFactory(factoria);
	}
	
	@Override
	public final void execute(ClienteDomain domain) {
		
		RegistrarClienteValidator.ejecutarValidacion(domain);
		
		validarNoExistenciaClienteConMismoNumeroTelefono(domain.getNumeroTelefono());
		
		validarNoExistenciaClienteConMismoCorreoElectronico(domain.getCorreoElectronico());
		
		validarNoExistenciaClienteConMismoIdentificacion(domain.getIdentificacion());
		
		domain = obtenerIdentificadorCliente(domain);
		
		registrarNuevoCliente(domain);
	}
	
	private void registrarNuevoCliente(final ClienteDomain domain ) {
		var entity = ClienteEntityMapper.convertToEntity(domain);
		getClienteDAO().crear(entity);
		
	}
	
	private final void validarNoExistenciaClienteConMismoIdentificacion(final String identificacion) {
		 var entity = crearClienteEntityIdentificacion(identificacion);
		    var resultados = getClienteDAO().consultar(entity);
		    if (!resultados.isEmpty()) {
		        String mensajeUsuario = "Ya existe cliente con el número de identificación: " + identificacion;
		        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		    }
	}
	private final ClienteEntity crearClienteEntityIdentificacion(final String identificacion) {
	    var domain = ClienteDomain.crear(null, null, identificacion, null, null, null, null);
	    return ClienteEntityMapper.convertToEntity(domain);
	}
	
	private final void validarNoExistenciaClienteConMismoCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
		 var entity = crearClienteEntityCorreoElectronico(correoElectronico);
		    var resultados = getClienteDAO().consultar(entity);
		    
		    if (!resultados.isEmpty()) {
		        String mensajeUsuario = "Ya existe cliente con el correo Electronico : " + correoElectronico;
		        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		    }
	}
	private ClienteEntity crearClienteEntityCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
	    var domain = ClienteDomain.crear(null, null, null, null, correoElectronico, null, null);
	    return ClienteEntityMapper.convertToEntity(domain);
	}
	
	private final void validarNoExistenciaClienteConMismoNumeroTelefono(final NumeroTelefonoClienteDomain numeroTelefono) {
		 var entity = crearClienteEntityNumeroTelefono(numeroTelefono);
		    var resultados = getClienteDAO().consultar(entity);
		    if (!resultados.isEmpty()) {
		        String mensajeUsuario = "Ya existe cliente con el numero de teléfono : " + numeroTelefono.toString();
		        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		    }
	}
	private ClienteEntity crearClienteEntityNumeroTelefono(final NumeroTelefonoClienteDomain numeroTelefono) {
	    var domain = ClienteDomain.crear(null, null, null, null, null, numeroTelefono, null);
	    return ClienteEntityMapper.convertToEntity(domain);
	}
	
	private final ClienteDomain obtenerIdentificadorCliente(final ClienteDomain domain) {
		
		Optional<ClienteEntity> optional;
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
			optional = getClienteDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return ClienteDomain.crear(uuid, domain.getTipoIdentificacion(), domain.getIdentificacion(),
				domain.getNombreCompleto(), domain.getCorreoElectronico(), domain.getNumeroTelefono(), domain.getFechaNacimiento());
	}
	

	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}

	public final DAOFactory getFactoria() {
		return factoria;
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
