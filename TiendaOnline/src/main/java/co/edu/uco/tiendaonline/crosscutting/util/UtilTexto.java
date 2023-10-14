package co.edu.uco.tiendaonline.crosscutting.util;

public final class  UtilTexto {
	
	public static final String VACIO = "";
	
	private UtilTexto() {
		super();
	}
	
	public static final String obtenerValorDefecto(final String valor, final String valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final String aplicarTrim(final String valor){
		return obtenerValorDefecto(valor).trim();
		
	}
	
	public static final String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	
	public static final boolean igualSinTrim(final String primerValor, final String segundoValor) {
		return obtenerValorDefecto(primerValor).equals(obtenerValorDefecto(segundoValor));
	}
	
	public static final boolean igualConTrim(final String primerValor, final String segundoValor) {
		return aplicarTrim(primerValor).equals(aplicarTrim(segundoValor));
	}
	
	public static final boolean igualSinTrimIgnorandoCase(final String primerValor, final String segundoValor) {
		return obtenerValorDefecto(primerValor).equalsIgnoreCase(obtenerValorDefecto(segundoValor));
	}
	
	public static final boolean igualConTrimIgnoreCase(final String primerValor, final String segundoValor) {
		return aplicarTrim(primerValor).equalsIgnoreCase(aplicarTrim(segundoValor));
	}
	public static final boolean estaNulo(final String valor) {
		return UtilObjeto.esNulo(valor);
	}
	public static final boolean estaVacio(final String valor) {
		return igualConTrim(valor, VACIO);
	}
}
