package co.edu.uco.tiendaonline.data.dao.base;

import java.sql.Connection;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrosscuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilSQL;

public class SQLDAO {
	
	private Connection conexion;
	
	protected SQLDAO(final Connection conexion) {
		setConexion(conexion);
	}

	protected final Connection getConexion() {
		return conexion;
	}

	private final  void setConexion(final Connection conexion) {
		if(!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000040);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}

		this.conexion = conexion;	
		
	}

	
}
