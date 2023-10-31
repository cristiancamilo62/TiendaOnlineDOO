package co.edu.uco.tiendaonline.service.mapper.entity.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.CorreoElectronicoClienteEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.NombreCompletoClienteEntityMapper;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.support.NumeroTelefonoClienteEntityMapper;

public final class ClienteEntityMapper implements EntityMapper<ClienteEntity, ClienteDomain> {
	
	private static final EntityMapper<ClienteEntity, ClienteDomain> instancia = new ClienteEntityMapper();
	
	private ClienteEntityMapper() {
		super();
	}

	@Override
	public final ClienteDomain toDomain(final ClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ClienteDomain.crear(entity.getId(),null, entity.getIdentificacion(),
				NombreCompletoClienteEntityMapper.convertToDomain(entity.getNombreCompleto()), CorreoElectronicoClienteEntityMapper.convertToDomain(entity.getCorreoElectronico()),
				NumeroTelefonoClienteEntityMapper.convertToDomain(entity.getNumeroTelefono()), entity.getFechaNacimiento());
	}

	@Override
	public final ClienteEntity toEntity(final ClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000042);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ClienteEntity.crear(domain.getId(), null , domain.getIdentificacion(),
				NombreCompletoClienteEntityMapper.convertToEntity(domain.getNombreCompleto()), CorreoElectronicoClienteEntityMapper.convertToEntity(domain.getCorreoElectronico()),
				NumeroTelefonoClienteEntityMapper.convertToEntity(domain.getNumeroTelefono()), domain.getFechaNacimiento());
	}
	
	public static final ClienteDomain convertToDomain(final ClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final ClienteEntity convertToEntity(final ClienteDomain domain) {
		return instancia.toEntity(domain);
	}

}