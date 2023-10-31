package co.edu.uco.tiendaonline.service.domain.cliente.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public final class CorreoElectronicoClienteDomain {
	
	private String correoElectronico;
	private  boolean correoElectronicoConfirmado;
	
	public CorreoElectronicoClienteDomain() {
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(false);
	}
	
	private CorreoElectronicoClienteDomain(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoClienteDomain crear(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		return new CorreoElectronicoClienteDomain(correoElectronico, correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoClienteDomain crear() {
		return new CorreoElectronicoClienteDomain();
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}

}
