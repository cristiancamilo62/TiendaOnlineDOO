package co.edu.uco.tiendaonline.service.mapper.dto.concrete.support;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;

public final class NombreCompletoClienteDTOMapper implements DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain>{

	private static final DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain> instancia = new NombreCompletoClienteDTOMapper();
	
	private NombreCompletoClienteDTOMapper() {
		super();
	}
	@Override
	public final NombreCompletoClienteDomain toDomain(final NombreCompletoClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000041);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoClienteDomain.crear(dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(), dto.getSegundoApellido());
	}

	@Override
	public final NombreCompletoClienteDTO toDTO(final NombreCompletoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000042);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoClienteDTO.crear(domain.getPrimerNombre(), domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegundoApellido());
	}
	
	public static final NombreCompletoClienteDomain convertToDomain(final NombreCompletoClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NombreCompletoClienteDTO convertToDTO(final NombreCompletoClienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
