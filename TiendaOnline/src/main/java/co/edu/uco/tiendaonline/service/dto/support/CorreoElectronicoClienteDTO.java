package co.edu.uco.tiendaonline.service.dto.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class CorreoElectronicoClienteDTO {
	private String correoElectronico;
	private  boolean correoElectronicoConfirmado;
	
	public CorreoElectronicoClienteDTO() {
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(false);
	}
	
	public CorreoElectronicoClienteDTO(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoClienteDTO crear(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		return new CorreoElectronicoClienteDTO(correoElectronico, correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoClienteDTO crear() {
		return new CorreoElectronicoClienteDTO();
	}
	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}

	private final CorreoElectronicoClienteDTO setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
		return this;
	}

	private final CorreoElectronicoClienteDTO setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
		return this;
	}
	
	
	

	
}