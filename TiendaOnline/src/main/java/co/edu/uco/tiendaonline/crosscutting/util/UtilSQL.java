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
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000007);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			return  !conexion.isClosed();
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000005);
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
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000008);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000009);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.close();
		} catch (final CrosscuttingTiendaOnlineException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000010);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000011);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}
	
	public static final void iniciarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000012);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000013);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
			if(!conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000014);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.setAutoCommit(false);
		} catch (final CrosscuttingTiendaOnlineException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000015);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000016);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}
	public static final void confirmarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000017);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if(conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000018);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000019);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.commit();
		} catch (final CrosscuttingTiendaOnlineException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000020);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000021);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}
	public static final void cancelarTransaccion(final Connection conexion) {
		if(UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000022);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		try {
			if(conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000023);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
			if(conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000024);
				throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
			conexion.rollback();
		} catch (final CrosscuttingTiendaOnlineException excepcion) {
			throw excepcion;
		}catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000025);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000026);
			throw CrosscuttingTiendaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}

}
