package co.edu.uco.tiendaonline.crosscutting.exception;

import co.edu.uco.tiendaonline.crosscutting.exception.enumerator.LugarException;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class TiendaOnlineException extends RuntimeException {

	
	private static final long serialVersionUID = -551425372694998396L;

	private LugarException lugar;
	private Throwable exceptionRaiz;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private boolean existeExcepcionRaiz;
	
	
	
	protected TiendaOnlineException(final LugarException lugar, final Throwable exceptionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		setLugar(lugar);
		setExceptionRaiz(exceptionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
	}
	
	private final void setLugar(final LugarException lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto(lugar, LugarException.GENERAL);
	}
	
	private final void setExceptionRaiz(final Throwable exceptionRaiz) {
		setExisteExcepcionRaiz(!UtilObjeto.esNulo(exceptionRaiz));
		this.exceptionRaiz = UtilObjeto.obtenerValorDefecto(exceptionRaiz, new Exception());
	}
	
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.aplicarTrim(mensajeUsuario);
	}
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.aplicarTrim(mensajeTecnico);
	}
	
	private final void setExisteExcepcionRaiz(final boolean existeExcepcionRaiz) {
		this.existeExcepcionRaiz = existeExcepcionRaiz;
	}
	public final LugarException getLugar() {
		return this.lugar;
	}
	public final Throwable getExceptionRaiz() {
		return this.exceptionRaiz;
	}
	public final String getMensajeUsuario() {
		return this.mensajeUsuario;
	}
	public final String getMensajeTecnico() {
		return this.mensajeTecnico;
	}
	public final boolean isExisteExcepcionRaiz() {
		return this.existeExcepcionRaiz;
	}
	
	
}
