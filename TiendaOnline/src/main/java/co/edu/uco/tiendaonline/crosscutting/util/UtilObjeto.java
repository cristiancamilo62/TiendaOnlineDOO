package co.edu.uco.tiendaonline.crosscutting.util;

public final class UtilObjeto {
	
	private UtilObjeto() {
		super();
	}

	public static final <O> boolean esNulo(final O objeto) {
		return objeto == null;
	}
	
	public static final <O> O obtenerValorDefecto(final O objecto, final O valorDefecto) {
		
		return esNulo(objecto) ? valorDefecto : objecto;
}
}
