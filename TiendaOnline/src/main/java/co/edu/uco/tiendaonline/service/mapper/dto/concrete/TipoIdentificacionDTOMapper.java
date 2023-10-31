package co.edu.uco.tiendaonline.service.mapper.dto.concrete;


import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;


public class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> {
	
	private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();
	
	private TipoIdentificacionDTOMapper() {
		super();
	}
	@Override
	public final TipoIdentificacionDomain toDomain(final TipoIdentificacionDTO dto) {
		
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000027);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TipoIdentificacionDomain.crear(dto.getId(), dto.getCodigo(), dto.getNombre(), dto.isEstado());
	}


	@Override
	public final TipoIdentificacionDTO toDTO(final TipoIdentificacionDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000028);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TipoIdentificacionDTO.crear(domain.getId(), domain.getCodigo(), domain.getNombre(), domain.isEstado());
	}
	
	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final TipoIdentificacionDTO convertToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDTO(domain);
	}

}
