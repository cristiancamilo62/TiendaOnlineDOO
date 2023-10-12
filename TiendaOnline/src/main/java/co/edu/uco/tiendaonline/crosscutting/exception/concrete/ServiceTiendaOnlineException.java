package co.edu.uco.tiendaonline.crosscutting.exception.concrete;

import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;

public class ServiceTiendaOnlineException extends TiendaOnlineException{

	
	private static final long serialVersionUID = -1983857422301149874L;
	
	protected ServiceTiendaOnlineException(final Throwable exceptionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.SERVICE, exceptionRaiz, mensajeUsuario, mensajeTecnico);
	}

	public static final TiendaOnlineException crear(final String mensajeUsuario) {
		return new ServiceTiendaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final TiendaOnlineException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceTiendaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}

	public static final TiendaOnlineException crear(final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceTiendaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

}
