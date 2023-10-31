package co.edu.uco.tiendaonline.data.entity.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class NumeroTelefonoClienteEntity {
	private String numeroTelefono;
	private boolean numeroTelefonoConfirmado;
	
	public NumeroTelefonoClienteEntity() {
		setNumeroTelefono(UtilTexto.VACIO);
		setNumeroTelefonoConfirmado(false);
	}
	
	private NumeroTelefonoClienteEntity(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		setNumeroTelefono(numeroTelefono);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoClienteEntity crear(final String numeroTelefono, final boolean numeroTelefonoConfirmado) {
		return new NumeroTelefonoClienteEntity(numeroTelefono, numeroTelefonoConfirmado);
	}
	
	public static final NumeroTelefonoClienteEntity crear() {
		return new NumeroTelefonoClienteEntity();
	}

	public final String getNumeroTelefono() {
		return numeroTelefono;
	}

	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}

	private final void setNumeroTelefono(final String numeroTelefono) {
		this.numeroTelefono = UtilTexto.obtenerValorDefecto(numeroTelefono);
	}

	private final void setNumeroTelefonoConfirmado(final boolean numeroTelefonoConfirmado) {
		this.numeroTelefonoConfirmado = UtilObjeto.obtenerValorDefecto(numeroTelefonoConfirmado, false);
	}

	
}