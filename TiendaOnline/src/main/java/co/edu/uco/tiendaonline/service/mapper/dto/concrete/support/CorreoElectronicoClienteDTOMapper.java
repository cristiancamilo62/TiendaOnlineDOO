package co.edu.uco.tiendaonline.service.mapper.dto.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;


public final class CorreoElectronicoClienteDTOMapper implements DTOMapper<CorreoElectronicoClienteDTO, CorreoElectronicoClienteDomain> {
	
	private static final DTOMapper<CorreoElectronicoClienteDTO, CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoClienteDTOMapper();
	
	private CorreoElectronicoClienteDTOMapper() {
		super();
	}

	@Override
	public final CorreoElectronicoClienteDomain toDomain(final CorreoElectronicoClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return CorreoElectronicoClienteDomain.crear(dto.getCorreoElectronico(), false);
	}

	@Override
	public final CorreoElectronicoClienteDTO toDTO(final CorreoElectronicoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000042);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return CorreoElectronicoClienteDTO.crear(domain.getCorreoElectronico(), false);
	}

	public static final CorreoElectronicoClienteDomain convertToDomain(final CorreoElectronicoClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final CorreoElectronicoClienteDTO convertToDTO(final CorreoElectronicoClienteDomain domain) {
		return instancia.toDTO(domain);
	}
}
