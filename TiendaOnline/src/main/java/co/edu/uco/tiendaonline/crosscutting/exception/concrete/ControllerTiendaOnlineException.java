package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public class ControllerTiendaOnlineException extends TiendaOnlineException {

	private static final long serialVersionUID = 7008202307513041484L;
	
	protected ControllerTiendaOnlineException(final Throwable exceptionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.CONTROLLER, exceptionRaiz, mensajeUsuario, mensajeTecnico);
		
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new ControllerTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}

	public static final TiendaOnlineException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerTiendaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

}
 