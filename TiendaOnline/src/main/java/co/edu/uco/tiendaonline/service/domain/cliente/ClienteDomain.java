package co.edu.uco.tiendaonline.service.domain.cliente;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilDate;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUuid;
import co.edu.uco.tiendaonline.service.domain.cliente.support.CorreoElectronicoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NumeroTelefonoClienteDomain;
import co.edu.uco.tiendaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;


public final class ClienteDomain {
	
	private UUID id;
	private TipoIdentificacionDomain tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoClienteDomain correoElectronico;
	private NumeroTelefonoClienteDomain numeroTelefono;
	private Date fechaNacimiento;


	private ClienteDomain(final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion, final NombreCompletoClienteDomain nombreCompleto,
			CorreoElectronicoClienteDomain correoElectronico, NumeroTelefonoClienteDomain numeroTelefono, final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroTelefono(numeroTelefono);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public static final ClienteDomain crear(final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion, final NombreCompletoClienteDomain nombreCompleto,
			CorreoElectronicoClienteDomain correoElectronico, NumeroTelefonoClienteDomain numeroTelefono, final Date fechaNacimiento) {
		
		return new ClienteDomain(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefono,fechaNacimiento);
	}
	
	private final void setId(UUID id) {
		this.id = UtilObjeto.obtenerValorDefecto(id, UtilUuid.DEFAULT_UUID);
	}
	private final void setTipoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefecto(tipoIdentificacion, new TipoIdentificacionDomain());
	}
	private final void setIdentificacion(final String identificacion) {
		this.identificacion = UtilTexto.aplicarTrim(identificacion);
	}
	
	private final void setNombreCompleto(final NombreCompletoClienteDomain  nombreCompleto) {
		this.nombreCompleto = UtilObjeto.obtenerValorDefecto(nombreCompleto, new NombreCompletoClienteDomain());
	}
	
	private final void setCorreoElectronico(final CorreoElectronicoClienteDomain  correoElectronico) {
		this.correoElectronico = UtilObjeto.obtenerValorDefecto(correoElectronico, new CorreoElectronicoClienteDomain());
	}

	private final void setNumeroTelefono(final NumeroTelefonoClienteDomain  numeroTelefono) {
		this.numeroTelefono = UtilObjeto.obtenerValorDefecto(numeroTelefono,new NumeroTelefonoClienteDomain());
	}
	
	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = UtilObjeto.obtenerValorDefecto(fechaNacimiento, UtilDate.crearFechaPorDefecto());
	}

	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDomain  getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	
	public final NombreCompletoClienteDomain  getNombreCompleto() {
		return nombreCompleto;
	}

	public final CorreoElectronicoClienteDomain  getCorreoElectronico() {
		return correoElectronico;
	}

	public final NumeroTelefonoClienteDomain  getNumeroTelefono() {
		return numeroTelefono;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
	

}
