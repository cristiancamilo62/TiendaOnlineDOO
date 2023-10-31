package co.edu.uco.tiendaonline.service.domain.cliente.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class NumeroTelefonoClienteDomain {
	
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	
	public NumeroTelefonoClienteDomain() {
		setNumeroTelefono(UtilTexto.VACIO);
		setNumeroTelefonoConfirmado(false);

	}
	
	private NumeroTelefonoClienteDomain(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoClienteDomain crear(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		return new NumeroTelefonoClienteDomain(numeroTelefono, numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoClienteDomain crear() {
		return new NumeroTelefonoClienteDomain();
	}
	public final String getNumeroTelefono() {
		return numeroTelefono;
	}

	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}

	private final void setNumeroTelefono(final String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	private final void setNumeroTelefonoConfirmado(final boolean numeroTelefonoConfirmado) {
		this.numeroTelefonoConfirmado = numeroTelefonoConfirmado;
	}


}
