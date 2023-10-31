package co.edu.uco.tiendaonline.service.mapper.dto.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoClienteDomain;
import co.edu.uco.tiendaonline.service.dto.support.NumeroTelefonoClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;

public final class NumeroTelefonoClienteDTOMapper implements DTOMapper<NumeroTelefonoClienteDTO, NumeroTelefonoClienteDomain>{

	private static final DTOMapper<NumeroTelefonoClienteDTO, NumeroTelefonoClienteDomain> instancia = new NumeroTelefonoClienteDTOMapper();
	
	@Override
	public final NumeroTelefonoClienteDomain toDomain(final NumeroTelefonoClienteDTO entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NumeroTelefonoClienteDomain.crear(entity.getNumeroTelefono(), false);
	}

	@Override
	public final NumeroTelefonoClienteDTO toDTO(final NumeroTelefonoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000042);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NumeroTelefonoClienteDTO.crear(domain.getNumeroTelefono(), false);
	}
	public static final NumeroTelefonoClienteDomain convertToDomain(final NumeroTelefonoClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NumeroTelefonoClienteDTO convertToDTO(final NumeroTelefonoClienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
