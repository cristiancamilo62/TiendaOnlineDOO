package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;

public final class TipoIdentificacionSQLServerDAO extends SQLDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final TipoIdentificacionEntity entity) {

		final var sentencia = new StringBuilder();
		sentencia.append("INSERT INTO TipoIdentificacion (id, codigo, nombre, estado) ");
		sentencia.append("VALUES (?,?,?,?)");

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getCodigo());
			sentenciaPreparada.setString(3, entity.getNombre());
			sentenciaPreparada.setBoolean(4, entity.isEstado());

			sentenciaPreparada.executeUpdate();
		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de registrar la información del nuevo"
					+ "tipo de identificación....";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExcepcion en el metodo crear de la clase"
					+ "TipoIdentificaciónSQLServer tratando de llevar a cabo el registro del nuevo TipoIdentificacion"
					+ "por favor revise la traza del problema presentado para así poder identificar que sucedio ";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de registrar la información del nuevo"
					+ "tipo de identificación....";
			var mensajeTecnico = "Se ha presentado un problema de tipo Excepcion en el metodo crear de la clase"
					+ "TipoIdentificaciónSQLServer tratando de llevar a cabo el registro del nuevo TipoIdentificacion"
					+ "Por favor revise la traza del problema presentado para así poder identificar que sucedio.";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {

		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append("WHERE ID = ? ");

		Optional<TipoIdentificacionEntity> resultado = Optional.empty();

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setObject(1, id);

			resultado = ejecutarConsultaPorId(sentenciaPreparada);

		} catch (final DataTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de consultar la información del Tipo de identificación"
					+ "por el identificador deseado";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExcepcion en el metodo consultar por id de la clase"
					+ "TipoIdentificaciónSQLServer tratando de preparar la sentencia SQL de la consulta del tipo de identificación deseado."
					+ "por favor revise la traza del problema presentado para así poder identificar que sucedio";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);

		} catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de consultar la información del tipo de Identificación"
					+ "por el identificador deseado";
			var mensajeTecnico = "Se ha presentado un problema de tipo Excepcion en el metodo consultar por id de la clase"
					+ "TipoIdentificaciónSQLServer tratando de preparar la sentencia SQL de la consulta del tipo de identificación deseado."
					+ "por favor revise la traza del problema presentado para así poder identificar que sucedio";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}
	
	
	private Optional<TipoIdentificacionEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {

				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(
						UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"),
						resultados.getString("nombre"), resultados.getBoolean("estado"));

				resultado = Optional.of(tipoIdentificacionEntity);
			}
		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de consultar la información del tipo de identificación"
					+ "por el identificador deseado...";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExcepcion en el metodo consultar por id de la clase"
					+ "TipoIdentificaciónSQLServer, tratando de recuperar los datos de la consulta del tipo de identificación deseada."
					+ "por favor revise el problema presentado para así poder identificar que sucedio..";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de consultar la información del tipo de identificación"
					+ "por el identificador deseado.";
			var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Excepcion en el metodo consultar por id de la clase"
					+ "TipoIdentificaciónSQLServer tratando de recuperar los datos de la consulta del tipo de identificación deseada."
					+ "por favor revise el problema presentado, para así poder identificar que sucedio";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}
	
	private final String formarSentenciaConsulta(final TipoIdentificacionEntity entity, final List<Object> parametros) {
		
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE";
		
		sentencia.append("SELECT id, codigo, nombre, estado "  );
		sentencia.append("From TipoIdentificación");
		
		if(!UtilObjeto.esNulo(entity)) {
			
			if(!UtilObjeto.esNulo(entity.getId())){
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
				
			}
			if(!UtilTexto.estaVacio(entity.getCodigo())) {
				sentencia.append(operadorCondicional).append(" codigo = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getCodigo());
			}
			if(!UtilTexto.estaVacio(entity.getCodigo())) {
				sentencia.append(operadorCondicional).append(" nombre = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getNombre());
			}
			if(!UtilObjeto.esNulo(entity.isEstado())) {
				sentencia.append(operadorCondicional).append(" estado. = ? ");
				parametros.add(entity.isEstado());
			}
		}
		
		sentencia.append("ORDER BY codigo ASC ");
		
		return sentencia.toString();
		
	}
	
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity entity) {
		final var parametros = new ArrayList<Object>();

		final String sentencia = formarSentenciaConsulta(entity,parametros);
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)){
			
			colocarParametrosConsulta(sentenciaPreparada,parametros);
			return ejecutarConsulta(sentenciaPreparada);
			
		}catch( final DataTiendaOnlineException excepcion) {
			throw excepcion;
		}
		catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema, trantando de llevar a cabo la consulta de los Tipos de identificación..";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExcepcion en el metodo prepararEjecutarSentenciaConsulta de la clase TipoIdentificacionSQLServerDAO"
					+ "tratando de preparar la sentencia SQL."
					+ "por favor revise el problema presentado para así poder identificar que sucedio...";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);	
		}catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de llevar a cabo la consulta de los Tipos de identificación..";
			var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Excepcion en el metodo prepararEjecutarSentenciaConsulta de la clase TipoIdentificacionSQLServerDAO"
					+ "tratando de preparar la sentencia SQL."
					+ "por favor revise el problema presentado para así poder identificar que sucedio..";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);	
		}
	}
	
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada,final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice<parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		}catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema, trantando de llevar a cabo la consulta de los Tipos de identificación..";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExcepcion en el metodo colocarParametrosconsulta de la clase TipoIdentificacionSQLServerDAO"
					+ "tratando de colocar los parametros de la consulta del tipo de identificación deseada."
					+ "por favor revise el problema presentado para así poder identificar que sucedio.";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema, trantando de llevar a cabo la colsulta de los Tipos de identificación..";
			var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Excepcion en el metodo colocarParametrosconsulta de la clase TipoIdentificacionSQLServerDAO"
					+ "tratando de colocar los parametros de la consulta del tipo de identificación deseada."
					+ "por favor revise el problema presentado para así poder identificar que sucedio....";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	
	private final List<TipoIdentificacionEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<TipoIdentificacionEntity>();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			while (resultados.next()) {

				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(
						UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"),
						resultados.getString("nombre"), resultados.getBoolean("estado"));

				listaResultados.add(tipoIdentificacionEntity);
			}
		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema, trantando de consultar la información del tipo de identificación";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExcepcion en el metodo ejecutarConsulta de la clase"
					+ "TipoIdentificaciónSQLServerDAO tratando de recuperar los datos de la consulta del tipo de identificación deseada."
					+ "por favor revise el problema presentado para así poder identificar que sucedio";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema, trantando de consultar la información del tipo de identificación"
					+ "por el identificador deseado.";
			var mensajeTecnico = "Se ha presentado un problema inesperado de tipo Excepcion en el metodo consultar por id de la clase"
					+ "TipoIdentificaciónSQLServer tratando de recuperar los datos de la consulta del tipo de identificación deseada."
					+ "por favor revise el problema presentado para así poder identificar que sucedio";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return listaResultados;
	}

	
}
