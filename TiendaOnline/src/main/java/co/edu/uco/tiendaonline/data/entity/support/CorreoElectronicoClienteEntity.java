package co.edu.uco.tiendaonline.data.entity.support;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;

public class CorreoElectronicoClienteEntity {
	private String correoElectronico;
	private  boolean correoElectronicoConfirmado;
	
	
	public CorreoElectronicoClienteEntity() {
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(false);
	}
	
	private CorreoElectronicoClienteEntity(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		}
	
	public static final CorreoElectronicoClienteEntity crear(final String correoElectronico, final boolean correoElectronicoConfirmado) {
		return new CorreoElectronicoClienteEntity(correoElectronico, correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoClienteEntity crear() {
		return new CorreoElectronicoClienteEntity();
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = UtilTexto.obtenerValorDefecto(correoElectronico);
	}

	private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = UtilObjeto.obtenerValorDefecto(correoElectronicoConfirmado,false);
	}
		
}