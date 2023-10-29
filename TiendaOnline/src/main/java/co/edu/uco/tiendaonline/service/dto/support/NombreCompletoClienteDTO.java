package co.edu.uco.tiendaonline.service.dto.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class NombreCompletoClienteDTO {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	public NombreCompletoClienteDTO(){
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
	}
	public NombreCompletoClienteDTO(final String primerNombre, final String segundoNombre, final String primerApellido,
			final String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
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
	private final NombreCompletoClienteDTO setPrimerNombre(final String primerNombre) {
		this.primerNombre = primerNombre;
		return this;
	}
	private final NombreCompletoClienteDTO setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = segundoNombre;
		return this;
	}
	private final NombreCompletoClienteDTO setPrimerApellido(final String primerApellido) {
		this.primerApellido = primerApellido;
		return this;
	}
	private final NombreCompletoClienteDTO setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = segundoApellido;
		return this;
	}
	
	
	
}