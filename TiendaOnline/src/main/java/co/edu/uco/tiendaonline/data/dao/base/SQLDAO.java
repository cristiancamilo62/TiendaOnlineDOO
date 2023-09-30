package co.edu.uco.tiendaonline.data.dao.base;

import java.sql.Connection;

public class SQLDAO {
	
	private Connection conexion;
	
	protected SQLDAO(final Connection conexion) {
		setConexion(conexion);
	}

	public final Connection getConexion() {
		return conexion;
	}

	private final  void setConexion(final Connection conexion) {
		//TODO: controlar que la conexion no sea nula, que no esté cerrada o
		// que ya no se haya confirmado una transacción
		this.conexion = conexion;
	}

	
}
