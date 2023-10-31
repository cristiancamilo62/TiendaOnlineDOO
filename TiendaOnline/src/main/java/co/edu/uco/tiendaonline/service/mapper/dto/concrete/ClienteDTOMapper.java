package co.edu.uco.tiendaonline.service.mapper.dto.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.CorreoElectronicoClienteDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.NombreCompletoClienteDTOMapper;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.support.NumeroTelefonoClienteDTOMapper;

public final class ClienteDTOMapper implements DTOMapper<ClienteDTO, ClienteDomain>{
	
private static final DTOMapper<ClienteDTO, ClienteDomain> instancia = new ClienteDTOMapper();
	
	private ClienteDTOMapper() {
		super();
	}

	@Override
	public final ClienteDomain toDomain(final ClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ClienteDomain.crear(dto.getId(), null, dto.getIdentificacion(),
				NombreCompletoClienteDTOMapper.convertToDomain(dto.getNombreCompleto()), CorreoElectronicoClienteDTOMapper.convertToDomain(dto.getCorreoElectronico()),
				NumeroTelefonoClienteDTOMapper.convertToDomain(dto.getNumeroTelefono()), dto.getFechaNacimiento());
	}

	@Override
	public final ClienteDTO toDTO(final ClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ClienteDTO.crear(domain.getId(), null, domain.getIdentificacion(),
				NombreCompletoClienteDTOMapper.convertToDTO(domain.getNombreCompleto()), CorreoElectronicoClienteDTOMapper.convertToDTO(domain.getCorreoElectronico()),
				NumeroTelefonoClienteDTOMapper.convertToDTO(domain.getNumeroTelefono()), domain.getFechaNacimiento());
	}
	
	public static final ClienteDomain convertToDomain(final ClienteDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final ClienteDTO convertToDTO(final ClienteDomain domain) {
		return instancia.toDTO(domain);
	}

	

}
