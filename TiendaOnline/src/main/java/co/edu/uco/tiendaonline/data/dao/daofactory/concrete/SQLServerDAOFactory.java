package co.edu.uco.tiendaonline.data.dao.daofactory.concrete;

import java.sql.Connection;

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
		// TODO: Your homework will be to obtain connection with SQL server data
		conexion = null;
		
	}

	@Override
	public final void cerrarConexion() {
		// TODO: Your homework will be to obtain connection 
		
	}

	@Override
	public final void iniciarTransaccion() {
		// TODO: Your homework will be to init transaction 
		
	}

	@Override
	public final void confirmarTransacion() {
		// TODO: Your homework will be to commit transaction 
		
	}

	@Override
	public void cancelarTransacion() {
		// TODO: Your homework will be to rollback transaction 
		
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
