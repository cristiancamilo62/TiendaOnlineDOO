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
import co.edu.uco.tiendaonline.crosscutting.util.UtilDate;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.base.SQLDAO;
import co.edu.uco.tiendaonline.data.entity.ClienteEntity;
import co.edu.uco.tiendaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.tiendaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.tiendaonline.data.entity.support.NumeroTelefonoClienteEntity;

public final class ClienteSQLServerDAO extends SQLDAO  implements ClienteDAO {

	public ClienteSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ClienteEntity entity) {
		
		final var sentencia = new StringBuilder();
	    sentencia.append("INSERT INTO Cliente (id, identificacion,primerNombre,segundoNombre"
	    		+ " primerApellido,segundoApellido, correoElectronico,correoElectronicoConfirmado, numeroTelefonoMovil,numeroTelefonoMovilConfirmado, fechaNacimiento) ");
	    sentencia.append("VALUES (?,?,?,?,?,?,?)");
	    
	    
	    try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
	    	
	    	sentenciaPreparada.setObject(1, entity.getId());
	    	sentenciaPreparada.setString(2, entity.getIdentificacion());
	    	sentenciaPreparada.setString(3, entity.getNombreCompleto().getPrimerNombre());
	    	sentenciaPreparada.setString(4, entity.getNombreCompleto().getSegundoNombre());
	    	sentenciaPreparada.setString(5, entity.getNombreCompleto().getPrimerApellido());
	    	sentenciaPreparada.setString(6, entity.getNombreCompleto().getSegundoApellido());
	    	sentenciaPreparada.setString(7, entity.getCorreoElectronico().getCorreoElectronico());
	    	sentenciaPreparada.setBoolean(8, entity.getCorreoElectronico().isCorreoElectronicoConfirmado());
	    	sentenciaPreparada.setString(9, entity.getNumeroTelefono().getNumeroTelefono());
	    	sentenciaPreparada.setBoolean(10, entity.getNumeroTelefono().isNumeroTelefonoConfirmado());
	    	
	    	sentenciaPreparada.setDate(6, entity.getFechaNacimiento());
	    	
	    	sentenciaPreparada.executeUpdate();
	    	
	    }catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000091);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000092);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario =  CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000091);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000093);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
	}
		
	


	@Override
	public final void eliminar(final UUID id) {
		final StringBuilder sentencia = new StringBuilder();
		
		sentencia.append("DELETE FROM Cliente WHERE id = ?" );
		
		try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000094);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000095);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000094);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000096);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public final Optional<ClienteEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT c.id, c.identificacion,t.codigo,t.nombre,c.primerNombre,c.segundoNombre,c.primerApellido,"
				+ "c.segundoApellido, c.correoElectronico,c.correoElectronicoConfirmado, c.numeroTelefonoMovil,c.numeroTelefonoMovilConfirmado,c.fechaNacimiento ");
		sentencia.append("FROM Cliente c ");
		sentencia.append("JOIN TipoIdentificacion t ON c.tipoIdentificacion = t.id ");
		sentencia.append("WHERE id = ? ");
		

		Optional<ClienteEntity> resultado = Optional.empty();

		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {

			sentenciaPreparada.setObject(1, id);

			resultado = ejecutarConsultaPorId(sentenciaPreparada);

		} catch (final DataTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000097);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000098);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);

		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000097);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000099);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}
	
	
	private Optional<ClienteEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		Optional<ClienteEntity> resultado = Optional.empty();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(null, resultados.getString("codigo"),
						resultados.getString("nombre"), false);
				
				var nombreCompletoPacienteEntity = NombreCompletoClienteEntity.crear(resultados.getString("primerNombre"),
						resultados.getString("segundoNombre"), resultados.getString("primerApellido"), resultados.getString("segundoApellido"));
				var correoElectronicoPacienteEntity = CorreoElectronicoClienteEntity.crear(
						resultados.getString("correoElectronico"), resultados.getBoolean("correoElectronicoConfirmado"));
				
				var numeroTelefonoPacienteEntity = NumeroTelefonoClienteEntity.crear(
						resultados.getString("numeroTelefono"), resultados.getBoolean("numeroTelefonoConfirmado"));
				
				
				var clienteEntity = ClienteEntity.crear(UUID.fromString(resultados.getObject("id").toString()),
						tipoIdentificacionEntity, resultados.getString("identificacion"), nombreCompletoPacienteEntity,
						correoElectronicoPacienteEntity, numeroTelefonoPacienteEntity, resultados.getDate("fechaNacimiento"));

				resultado = Optional.of(clienteEntity);
			}
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000097);
			var mensajeTecnico =  CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000100);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000097);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000101);
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}
	
	@Override
	public void modificar(ClienteEntity entity) {
		if(!UtilObjeto.esNulo(consultarPorId(entity.getId()))) {
			final String sentencia = formarSentenciaModificar(entity);
			try(final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentencia)){
				
				sentenciaPreparada.setString(1, entity.getIdentificacion());
			 	sentenciaPreparada.setString(2, entity.getNombreCompleto().getPrimerNombre());
			 	sentenciaPreparada.setString(3, entity.getNombreCompleto().getSegundoNombre());
			 	sentenciaPreparada.setString(4, entity.getNombreCompleto().getPrimerApellido());
		        sentenciaPreparada.setString(5, entity.getNombreCompleto().getSegundoApellido());
		        sentenciaPreparada.setString(6, entity.getCorreoElectronico().getCorreoElectronico());
		        sentenciaPreparada.setBoolean(7, entity.getCorreoElectronico().isCorreoElectronicoConfirmado());
		        sentenciaPreparada.setString(8, entity.getNumeroTelefono().getNumeroTelefono());
		        sentenciaPreparada.setBoolean(9, entity.getNumeroTelefono().isNumeroTelefonoConfirmado());
		        sentenciaPreparada.setDate(10, entity.getFechaNacimiento());
				
				sentenciaPreparada.executeUpdate();
		    } catch (SQLException excepcion) {
		        String mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000102);
		        String mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000103);
		        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		    }catch (Exception excepcion) {
		        String mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000102);
		        String mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000104);
		        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		    }
		}
		
		
	}
	
	private final String formarSentenciaModificar(final ClienteEntity entity) {
		
		 final StringBuilder sentencia = new StringBuilder();
		 
		 if(!UtilObjeto.esNulo(entity)) {
			 String operadorCondicional = "UPDATE Cliente SET";
			 
			 if(!UtilObjeto.esNulo(entity.getIdentificacion())) {
				 sentencia.append(operadorCondicional).append(" identificacion = ? ");
				 operadorCondicional = ",";
			 }
			 if(!UtilTexto.estaVacio(entity.getNombreCompleto().getPrimerNombre())) {
				 sentencia.append(operadorCondicional).append(" primerNombre = ? ");
				 operadorCondicional = ",";
			 }
			 if(!UtilTexto.estaVacio(entity.getNombreCompleto().getSegundoNombre())) {
				 sentencia.append(operadorCondicional).append(" segundoNombre = ? ");
				 operadorCondicional = ",";
			 }
			 if(!UtilTexto.estaVacio(entity.getNombreCompleto().getPrimerApellido())) {
				 sentencia.append(operadorCondicional).append(" primerApellido = ? ");
				 operadorCondicional = ",";
			 }
			 if(!UtilTexto.estaVacio(entity.getNombreCompleto().getSegundoApellido())) {
				 sentencia.append(operadorCondicional).append(" segundoApellido = ? ");
				 operadorCondicional = ",";
			 }
			 
			 if(!UtilTexto.estaVacio(entity.getCorreoElectronico().getCorreoElectronico())) {
				 sentencia.append(operadorCondicional).append(" correoElectronico = ? ");
				 operadorCondicional = ",";
			 }
			 if(!UtilTexto.estaVacio(entity.getNumeroTelefono().getNumeroTelefono())) {
				 sentencia.append(operadorCondicional).append(" numeroTelefonoMovil = ? ");
				 operadorCondicional = ",";
			 }
			 if(!UtilDate.tieneValorPorDefecto(entity.getFechaNacimiento())) {
				 sentencia.append(operadorCondicional).append(" fechaNacimiento = ? ");
			 }
			 if(!sentencia.isEmpty()) {
				 sentencia.append("WHERE id = ?");	
			 }
		 } 
		return sentencia.toString();
		
	}
	
	@Override
	public final List<ClienteEntity> consultar(final ClienteEntity entity) {
	    final var parametros = new ArrayList<Object>();

	    final String sentencia = formarSentenciaConsulta(entity, parametros);

	    try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
	        colocarParametrosConsulta(sentenciaPreparada, parametros);
	        return ejecutarConsulta(sentenciaPreparada);

	    } catch (final DataTiendaOnlineException excepcion) {
	        throw excepcion;
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000105);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000106);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000105);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000107);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
	}

	private final String formarSentenciaConsulta(final ClienteEntity entity, final List<Object> parametros) {

	    final var sentencia = new StringBuilder();
	    String operadorCondicional = "WHERE";

	    sentencia.append("SELECT id, identificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, correoElectronico, correoElectronicoConfirmado, numeroTelefonoMovil, numeroTelefonoMovilConfirmado, fechaNacimiento ");
	    sentencia.append("FROM Cliente");
	    if (!UtilObjeto.esNulo(entity)) {

	        if (!UtilObjeto.esNulo(entity.getId())) {
	            sentencia.append(operadorCondicional).append(" id = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getId());
	        }
	        if (!UtilTexto.estaVacio(entity.getIdentificacion())) {
	            sentencia.append(operadorCondicional).append(" identificacion = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getIdentificacion());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompleto().getPrimerNombre())) {
	            sentencia.append(operadorCondicional).append(" primerNombre = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompleto().getPrimerNombre());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompleto().getSegundoNombre())) {
	            sentencia.append(operadorCondicional).append(" segundoNombre = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompleto().getSegundoNombre());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompleto().getPrimerApellido())) {
	            sentencia.append(operadorCondicional).append(" primerApellido = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompleto().getPrimerApellido());
	        }
	        if (!UtilTexto.estaVacio(entity.getNombreCompleto().getSegundoApellido())) {
	            sentencia.append(operadorCondicional).append(" segundoApellido = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNombreCompleto().getSegundoApellido());
	        }
	        if (!UtilTexto.estaVacio(entity.getCorreoElectronico().getCorreoElectronico())) {
	            sentencia.append(operadorCondicional).append(" correoElectronico = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getCorreoElectronico().getCorreoElectronico());
	        }
	        if (!UtilTexto.estaVacio(entity.getNumeroTelefono().getNumeroTelefono())) {
	            sentencia.append(operadorCondicional).append(" numeroTelefonoMovil = ? ");
	            operadorCondicional = "AND";
	            parametros.add(entity.getNumeroTelefono().isNumeroTelefonoConfirmado());
	        }
	        if (!UtilDate.tieneValorPorDefecto(entity.getFechaNacimiento())) {
	            sentencia.append(operadorCondicional).append(" fechaNacimiento = ? ");
	            parametros.add(entity.getFechaNacimiento());
	        }
	    }

	    sentencia.append(" ORDER BY id ASC ");
	    return sentencia.toString();
	}

	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
	    try {
	        for (int indice = 0; indice < parametros.size(); indice++) {
	            sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
	        }
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000105);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000108);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000085);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000109);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
	}

	private final List<ClienteEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada) {
	    final var listaResultados = new ArrayList<ClienteEntity>();

	    try (final var resultados = sentenciaPreparada.executeQuery()) {
	        while (resultados.next()) {
	        	
	        	var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(null, resultados.getString("codigo"),
						resultados.getString("nombre"), false);
				
				var nombreCompletoPacienteEntity = NombreCompletoClienteEntity.crear(resultados.getString("primerNombre"),
						resultados.getString("segundoNombre"), resultados.getString("primerApellido"), resultados.getString("segundoApellido"));
				var correoElectronicoPacienteEntity = CorreoElectronicoClienteEntity.crear(
						resultados.getString("correoElectronico"), resultados.getBoolean("correoElectronicoConfirmado"));
				
				var numeroTelefonoPacienteEntity = NumeroTelefonoClienteEntity.crear(
						resultados.getString("numeroTelefono"), resultados.getBoolean("numeroTelefonoConfirmado"));
				
				
				var clienteEntity = ClienteEntity.crear(UUID.fromString(resultados.getObject("id").toString()),
						tipoIdentificacionEntity, resultados.getString("identificacion"), nombreCompletoPacienteEntity,
						correoElectronicoPacienteEntity, numeroTelefonoPacienteEntity, resultados.getDate("fechaNacimiento"));

	            listaResultados.add(clienteEntity);
	        }
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000105);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000110);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000105);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000111);
	        throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
	    return listaResultados;
	}
	
}
