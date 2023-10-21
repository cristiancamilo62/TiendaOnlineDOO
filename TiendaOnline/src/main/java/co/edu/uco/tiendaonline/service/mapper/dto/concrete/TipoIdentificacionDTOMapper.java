package co.edu.uco.tiendaonline.service.mapper.dto.concrete;


import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.tiendaonline.service.mapper.dto.DTOMapper;


public class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> {
	
	private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();
	
	private TipoIdentificacionDTOMapper() {
		super();
	}

	@Override
	public final TipoIdentificacionDomain toDomain(final TipoIdentificacionDTO entity) {
		
		return  null;
	}

	@Override
	public final TipoIdentificacionDTO toDTO(final TipoIdentificacionDomain domain) {
		return null;
	}
	
	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO entity) {
		return instancia.toDomain(entity);
	}
	
	public static final TipoIdentificacionDTO convertToEntity(final TipoIdentificacionDomain domain) {
		return instancia.toDTO(domain);
	}

}
