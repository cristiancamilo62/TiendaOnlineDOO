package co.edu.uco.tiendaonline.data.entity.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class NombreCompletoClienteEntity {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	public NombreCompletoClienteEntity() {
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
	}
	
	private NombreCompletoClienteEntity(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}
	public static final NombreCompletoClienteEntity crear(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoClienteEntity(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}
	
	public static final  NombreCompletoClienteEntity crear(){
		return new NombreCompletoClienteEntity();
	}
	
	public final String getPrimerNombre() {
		return primerNombre;
	}
	public final String getSegundoNombre() {
		return segundoNombre;
	}
	public final String getPrimerApellido() {
		return primerApellido;
	}
	public final String getSegundoApellido() {
		return segundoApellido;
	}
	private final void setPrimerNombre(final String primerNombre) {
		this.primerNombre = UtilTexto.obtenerValorDefecto(primerNombre);
	}
	private final void setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = UtilTexto.obtenerValorDefecto(segundoNombre);
	}
	private final void setPrimerApellido(final String primerApellido) {
		this.primerApellido = UtilTexto.obtenerValorDefecto(primerApellido);
	}
	private final void setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = UtilTexto.obtenerValorDefecto(segundoApellido);
	}
	
	
	
}