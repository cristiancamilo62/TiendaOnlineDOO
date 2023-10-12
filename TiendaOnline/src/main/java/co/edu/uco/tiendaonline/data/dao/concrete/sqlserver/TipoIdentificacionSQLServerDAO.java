package co.edu.uco.tiendaonline.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.DataTiendaOnlineException;
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

			try (final var resultados = sentenciaPreparada.executeQuery()) {
				if (resultados.next()) {

					var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(
							UUID.fromString(resultados.getObject("id").toString()), resultados.getString("codigo"),
							resultados.getString("nombre"), resultados.getBoolean("estado"));

					resultado = Optional.of(tipoIdentificacionEntity);
				}
			} catch (SQLException excepcion) {
				var mensajeUsuario = "Se ha presentado un problema, trantando de consultar la información del tipo de identificación"
						+ "por el identificador deseado.";
				var mensajeTecnico = "Se ha presentado un problema de tipo SQLExcepcion en el metodo consultar por id de la clase"
						+ "TipoIdentificaciónSQLServer tratando de recuperar los datos de la consulta del tipo de identificación deseada."
						+ "por favor revise el problema presentado para así poder identificar que sucedio";
				throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			}

		} catch (final DataTiendaOnlineException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de consultar la información del tipo de identificación"
					+ "por el identificador deseado";
			var mensajeTecnico = "Se ha presentado un problema de tipo SQLExcepcion en el metodo consultar por id de la clase"
					+ "TipoIdentificaciónSQLServer tratando de preparar la sentencia SQL de la consulta del tipo de identificación deseado."
					+ "por favor revise la traza del problema presentado para así poder identificar que sucedio";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);

		} catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema trantando de consultar la información del tipo de identificación"
					+ "por el identificador deseado";
			var mensajeTecnico = "Se ha presentado un problema de tipo Excepcion en el metodo consultar por id de la clase"
					+ "TipoIdentificaciónSQLServer tratando de preparar la sentencia SQL de la consulta del tipo de identificación deseado."
					+ "por favor revise la traza del problema presentado para así poder identificar que sucedio";
			throw DataTiendaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	@Override
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
