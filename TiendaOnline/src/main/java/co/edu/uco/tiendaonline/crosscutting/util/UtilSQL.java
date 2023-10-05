package co.edu.uco.tiendaonline.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrosscuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;

public final class UtilSQL {
	
	private UtilSQL() {
		super();
	}
	
	public static final boolean conexionAbierta(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "No es posible validar si una coxion esta abierta cuando es nula";
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			return  !conexion.isClosed();
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "No es posible validar si una coxion esta abierta cuando es nula";
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000006);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}
	
	public static final void cerrarConexion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "no es posible cerrar una conexión que esta nula";
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = "no es posible cerrar una conexión que ya esta cerrada";
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.close();
		} catch (final CrosscuttingTiendaOnlineException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "Se ha presentado un problema trantando de validar si la conexión "
					+ "SQL estaba cerrada. Se presento una excepción de tipo SQLException. Por favor "
					+ "verifique la traza completa del error presentado, para así poder diagnosticas "
					+ "con mayor certeza lo que sucedio. ";
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = "Se ha presentado un problema inesperado trantando de validar si"
					+ "la conexión SQL estaba abierta. Se presento una excepción generica de tipo Exception. "
					+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticas "
					+ "con mayor certeza lo que sucedio. ";
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}

}
