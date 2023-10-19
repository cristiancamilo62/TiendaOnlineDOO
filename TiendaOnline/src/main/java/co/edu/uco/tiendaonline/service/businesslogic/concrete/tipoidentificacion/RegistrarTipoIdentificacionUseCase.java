package co.edu.uco.tiendaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.swing.text.html.parser.Entity;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.service.businesslogic.UseCase;
import co.edu.uco.tiendaonline.service.domain.TipoIdentificacionDomain;
import co.edu.uco.tiendaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public final class RegistrarTipoIdentificacionUseCase  implements UseCase<TipoIdentificacionDomain>{
	
	private DAOFactory factoria;

	public RegistrarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}



	@Override
	public final void execute(TipoIdentificacionDomain domain) {
		
		//1. verificar la integridad de los datos
		//TODO: ¿como lo hago?
		
		validarNoexistenciaTipoIdentificacionConMismoCodigo(domain.getCodigo());
		
		validarNoexistenciaTipoIdentificacionConMismoNombre(domain.getNombre());
		
		domain = obtenerIdentificadorTipoIdentificacion(domain);
		
		registrarNuevoTipoIdentificacion(domain);
		
	}
	
	private void registrarNuevoTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
	}

	private final void validarNoexistenciaTipoIdentificacionConMismoNombre(final String nombre) {
		// TODO: ¿cómo lograr que esto no este tan feo?????
		var domain = TipoIdentificacionDomain.crear(null, null, nombre, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "ya existe un Tipo de identificación con el nombre : "+ nombre;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	private final void validarNoexistenciaTipoIdentificacionConMismoCodigo(final String codigo) {
		// TODO: ¿cómo lograr que esto no este tan feo?????
		var domain = TipoIdentificacionDomain.crear(null, codigo, null, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "ya existe un Tipo de identificación con el codigio: "+ codigo;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final TipoIdentificacionDomain obtenerIdentificadorTipoIdentificacion(final TipoIdentificacionDomain domain) {
		
		Optional<TipoIdentificacionEntity> optional;
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
			optional = getTipoIdentificacionDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return TipoIdentificacionDomain.crear(uuid, domain.getCodigo(), domain.getNombre(), domain.isEstado());
	}


	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDao();
	}



	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000029);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000030);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}

	
	
}
