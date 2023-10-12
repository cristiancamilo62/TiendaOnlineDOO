package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import co.edu.uco.tiendaonline.crosscutting.util.UtilSQL;
import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.tiendaonline.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}
	
	@Override
	protected final void abrirConexion() {
		conexion = null;
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}	

	@Override
	public final void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final void confirmarTransacion() { 
		UtilSQL.confirmarTransaccion(conexion);
	}

	@Override
	public void cancelarTransacion() {
		UtilSQL.cancelarTransaccion(conexion);
		
	}

	@Override
	public ClienteDAO obtenerClienteDao() {
		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDao() {
		return new TipoIdentificacionSQLServerDAO(conexion);
	}
	

}
