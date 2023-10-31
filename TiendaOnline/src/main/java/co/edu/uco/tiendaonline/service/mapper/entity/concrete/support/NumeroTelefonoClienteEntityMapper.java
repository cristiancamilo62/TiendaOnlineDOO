package co.edu.uco.tiendaonline.service.mapper.entity.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoClienteEntity;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoClienteDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.EntityMapper;

public final class NumeroTelefonoClienteEntityMapper implements EntityMapper<NumeroTelefonoClienteEntity, NumeroTelefonoClienteDomain>{

	private static final EntityMapper<NumeroTelefonoClienteEntity, NumeroTelefonoClienteDomain> instancia = new NumeroTelefonoClienteEntityMapper();
	
	private NumeroTelefonoClienteEntityMapper() {
		super();
	}
	@Override
	public final NumeroTelefonoClienteDomain toDomain(final NumeroTelefonoClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NumeroTelefonoClienteDomain.crear(entity.getNumeroTelefono(), false);
	}

	@Override
	public final NumeroTelefonoClienteEntity toEntity(final NumeroTelefonoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000042);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NumeroTelefonoClienteEntity.crear(domain.getNumeroTelefono(), false);
	}
	public static final NumeroTelefonoClienteDomain convertToDomain(final NumeroTelefonoClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NumeroTelefonoClienteEntity convertToEntity(final NumeroTelefonoClienteDomain domain) {
		return instancia.toEntity(domain);
	}

}
