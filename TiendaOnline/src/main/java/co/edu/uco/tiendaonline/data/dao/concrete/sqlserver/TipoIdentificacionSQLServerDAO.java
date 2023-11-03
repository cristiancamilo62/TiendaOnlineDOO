package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000067);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000068);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario =  CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000067);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000069);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} 
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity entity) {
			final String sentencia = formarSentenciaModificar(entity);
			try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia)){
				//TODO: organizar colocar parametros
				sentenciaPreparada.setString(1, entity.getCodigo());
				sentenciaPreparada.setString(2, entity.getNombre());
				//sentenciaPreparada.setBoolean(3, entity.isEstado());
				sentenciaPreparada.setObject(3, entity.getId());
				sentenciaPreparada.executeUpdate();
		    } catch (SQLException excepcion) {
		        String mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000070);
		        String mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000071);
		        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		    }catch (Exception excepcion) {
		        String mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000070);
		        String mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000072);
		        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		    }
		

	}
	
	private final String formarSentenciaModificar(final TipoIdentificacionEntity entity) {
		 final StringBuilder sentencia = new StringBuilder();
		 String operadorCondicional = "SET";
		 
		 sentencia.append("UPDATE TipoIdentificacion ");
		 if(!UtilObjeto.esNulo(entity)) {
			 if(!UtilTexto.estaVacio(entity.getCodigo())) {
				 sentencia.append(operadorCondicional).append(" codigo = ? ");
				 operadorCondicional = ",";
			 }
			 if(!UtilTexto.estaVacio(entity.getNombre())) {
				 sentencia.append(operadorCondicional).append(" nombre = ? ");
			 }
		 }
		sentencia.append("WHERE id = ?");	 
		return sentencia.toString();
		
	}

	@Override
	public final void eliminar(final UUID id) {
		final StringBuilder sentencia = new StringBuilder();
			
		sentencia.append("DELETE FROM TipoIdentificacion WHERE id = ?" );
		
		try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000073);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000074);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000073);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000075);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {

		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append("WHERE id = ? ");

		Optional<TipoIdentificacionEntity> resultado = Optional.empty();

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setObject(1, id);

			resultado = ejecutarConsultaPorId(sentenciaPreparada);

		} catch (final DataTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000076);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000077);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);

		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000076);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000078);
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000076);
			var mensajeTecnico =  CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000080);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000076);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000081);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}
	
	
	
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity entity) {
		final var parametros = new ArrayList<>();

		final String sentencia = formarSentenciaConsulta(entity,parametros);
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)){
			
			var sentenciaP = colocarParametrosConsulta(sentenciaPreparada,parametros);
			return ejecutarConsulta(sentenciaP);
			
		}catch( final DataTiendaOnlineException excepcion) {
			throw excepcion;
		}
		catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000082);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000083);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);	
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000082);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000084);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);	
		}
	}
	private final String formarSentenciaConsulta(final TipoIdentificacionEntity entity, final List<Object> parametros) {
		
		final var sentencia = new StringBuilder();
		String operadorCondicional = " WHERE";
		
		sentencia.append("SELECT id, codigo, nombre, estado "  );
		sentencia.append("From TipoIdentificacion");
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
			if(!UtilTexto.estaVacio(entity.getNombre())) {
				sentencia.append(operadorCondicional).append(" nombre = ? ");
				//operadorCondicional = "AND";
				parametros.add(entity.getNombre());
			}
			/*if(!UtilObjeto.esNulo(entity.isEstado())) {
				sentencia.append(operadorCondicional).append(" estado = ? ");
				parametros.add(entity.isEstado());
			}*/
		}
		
		sentencia.append("ORDER BY codigo ASC ");
		
		return sentencia.toString();
		
	}
	
	private final PreparedStatement colocarParametrosConsulta(final PreparedStatement sentenciaPreparada,final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice<parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		}catch (final SQLException excepcion) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000085);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000086);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000085);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000087);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return sentenciaPreparada;
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000088);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000089);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000088);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000090);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		System.out.println(listaResultados.size());
		return listaResultados;
	}

	
}
