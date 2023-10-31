package co.edu.uco.tiendaonline.service.dto.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class NumeroTelefonoClienteDTO {
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	
	public NumeroTelefonoClienteDTO() {
		setNumeroTelefono(UtilTexto.VACIO);
		setNumeroTelefonoConfirmado(false);
	}
	
	public NumeroTelefonoClienteDTO(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}

	public static final NumeroTelefonoClienteDTO crear (final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		return new NumeroTelefonoClienteDTO(numeroTelefono, numeroTelefonoConfirmado);
	}
	
	public static final NombreCompletoClienteDTO crear() {
		return new NombreCompletoClienteDTO();
	}
	public final String getNumeroTelefono() {
		return numeroTelefono;
	}

	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}

	private final NumeroTelefonoClienteDTO setNumeroTelefono(final String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
		return this;
	}

	private final NumeroTelefonoClienteDTO setNumeroTelefonoConfirmado(final boolean numeroTelefonoConfirmado) {
		this.numeroTelefonoConfirmado = numeroTelefonoConfirmado;
		return this;
	}

	
}