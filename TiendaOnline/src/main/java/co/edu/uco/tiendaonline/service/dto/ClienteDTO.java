package co.edu.uco.tiendaonline.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilDate;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUuid;
import co.edu.uco.tiendaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.tiendaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.tiendaonline.service.dto.support.NumeroTelefonoClienteDTO;

public class ClienteDTO {
	private UUID id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDTO nombreCompleto;
	private CorreoElectronicoClienteDTO correoElectronico;
	private NumeroTelefonoClienteDTO numeroTelefono;
	private Date fechaNacimiento;
	
	
	public ClienteDTO(final UUID id, final TipoIdentificacionDTO tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDTO nombreCompleto, final CorreoElectronicoClienteDTO correoElectronico,
			final NumeroTelefonoClienteDTO numeroTelefono, final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacionDTO(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompletoDTO(nombreCompleto);
		setCorreoElectronicoDTO(correoElectronico);
		setNumeroTelefonoDTO(numeroTelefono);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public ClienteDTO() {
		setId(UtilUuid.DEFAULT_UUID);
		setTipoIdentificacionDTO(new TipoIdentificacionDTO());
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompletoDTO(new NombreCompletoClienteDTO());
		setCorreoElectronicoDTO(new CorreoElectronicoClienteDTO());
		setNumeroTelefonoDTO(new NumeroTelefonoClienteDTO());
		setFechaNacimiento(UtilDate.crearFechaPorDefecto());
	}

	public static final ClienteDTO crear(final UUID id, final TipoIdentificacionDTO tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDTO nombreCompleto, final CorreoElectronicoClienteDTO correoElectronico,
			final NumeroTelefonoClienteDTO numeroTelefono, final Date fechaNacimiento) {
		return new ClienteDTO(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefono, fechaNacimiento);
	}
	public static final ClienteDTO crear() {
		return new ClienteDTO();
	}

	public final UUID getId() {
		return id;
	}


	public final ClienteDTO setId(final UUID id) {
		this.id = id;
		return this;
	}


	public final TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public final ClienteDTO setTipoIdentificacionDTO(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
		return this;
	}


	public final String getIdentificacion() {
		return identificacion;
	}


	public final ClienteDTO setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
		return this;
	}


	public final NombreCompletoClienteDTO getNombreCompleto() {
		return nombreCompleto;
	}


	public final ClienteDTO setNombreCompletoDTO(final NombreCompletoClienteDTO nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}


	public final CorreoElectronicoClienteDTO getCorreoElectronico() {
		return correoElectronico;
	}


	public final ClienteDTO setCorreoElectronicoDTO(final CorreoElectronicoClienteDTO correoElectronico) {
		this.correoElectronico = correoElectronico;
		return this;
	}


	public final NumeroTelefonoClienteDTO getNumeroTelefono() {
		return numeroTelefono;
	}


	public final ClienteDTO setNumeroTelefonoDTO(final NumeroTelefonoClienteDTO numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
		return this;
	}


	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public final ClienteDTO setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}
	
	
	
	
}
