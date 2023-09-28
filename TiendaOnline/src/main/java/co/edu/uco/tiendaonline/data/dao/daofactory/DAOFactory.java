package co.edu.uco.tiendaonline.data.dao.daofactory;

import co.edu.uco.tiendaonline.data.dao.ClienteDAO;
import co.edu.uco.tiendaonline.data.dao.TipoIdentificacionDAO;

public abstract class DAOFactory {
	
	protected abstract void abrirConexion();
	public abstract void cerrarConexion();
	public abstract void iniciarTransaccion();
	public abstract void confirmarTransacion();
	public abstract void cancelarTransacion();
	public abstract ClienteDAO obtenerClienteDao();
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDao();
}
