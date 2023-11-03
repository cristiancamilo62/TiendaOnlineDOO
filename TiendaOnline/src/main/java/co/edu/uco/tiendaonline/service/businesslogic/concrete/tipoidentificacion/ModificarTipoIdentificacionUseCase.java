package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.businesslogic.validator.concrete.tipoidentificacion.ModificarTipoIdentificacionValidator;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class ModificarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain>{

	private DAOFactory factoria;
	
	
	public ModificarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public final void execute(final TipoIdentificacionDomain domain) {
		
		ModificarTipoIdentificacionValidator.ejecutarValidacion(domain);
		
		validarExistenciaTipoIdentificacionAModificar(domain.getId());
		
		//validarNoexistenciaTipoIdentificacionConMismoCodigoAModificar(domain.getCodigo());
		
		//validarNoexistenciaTipoIdentificacionConMismoNombreAModificar(domain.getNombre());
		
		modificarTipoIdentificacion(domain);
		
	}
	
	private void modificarTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().modificar(entity);
	}

	private final void validarExistenciaTipoIdentificacionAModificar(final UUID id) {
	    var entity = crearTipoIdentificacionEntityIdAModificar(id);
	    var resultados = getTipoIdentificacionDAO().consultarPorId(entity.getId());
	    if (resultados.isEmpty()) {
	        String mensajeUsuario = "No existe el tipo de identificacion que se desea modificar";
	        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
	    }
	}

	private TipoIdentificacionEntity crearTipoIdentificacionEntityIdAModificar(final UUID id) {
	    var domain = TipoIdentificacionDomain.crear(id, null, null, false);
	    return TipoIdentificacionEntityMapper.convertToEntity(domain);
	}
	
	private final void validarNoexistenciaTipoIdentificacionConMismoNombreAModificar(final String nombre) {
	    var entity = crearTipoIdentificacionEntityNombreAModificar(nombre);
	    var resultados = getTipoIdentificacionDAO().consultar(entity);
	    if (!resultados.isEmpty()) {
	        String mensajeUsuario = "Ya existe un Tipo de identificación con el nombre: " + nombre;
	        throw ServiceTiendaOnlineException.crear(mensajeUsuario);
	    }
	}

	private TipoIdentificacionEntity crearTipoIdentificacionEntityNombreAModificar(final String nombre) {
	    var domain = TipoIdentificacionDomain.crear(null, null, nombre, false);
	    return TipoIdentificacionEntityMapper.convertToEntity(domain);
	}
	
	private final void validarNoexistenciaTipoIdentificacionConMismoCodigoAModificar(final String codigo) {
		TipoIdentificacionEntity entity = crearTipoIdentificacionEntityCodigoAModificar(codigo);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "ya existe un Tipo de identificación con el codigio: "+ codigo;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	private final TipoIdentificacionEntity crearTipoIdentificacionEntityCodigoAModificar(final String codigo) {
	    var domain = TipoIdentificacionDomain.crear(null, codigo, null, false);
	    return TipoIdentificacionEntityMapper.convertToEntity(domain);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final TipoIdentificacionDAO getTipoIdentificacionDAO () {
		return getFactoria().obtenerTipoIdentificacionDAO();
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
