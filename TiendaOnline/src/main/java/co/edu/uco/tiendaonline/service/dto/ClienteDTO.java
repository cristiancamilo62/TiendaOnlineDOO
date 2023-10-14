package co.edu.uco.tiendaonline.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
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
	
	
	public ClienteDTO(UUID id, TipoIdentificacionDTO tipoIdentificacion, String identificacion,
			NombreCompletoClienteDTO nombreCompleto, CorreoElectronicoClienteDTO correoElectronico,
			NumeroTelefonoClienteDTO numeroTelefono, Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacionDTO(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompletoDTO(nombreCompleto);
		setCorreoElectronicoDTO(correoElectronico);
		setNumeroTelefonoDTO(numeroTelefono);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public ClienteDTO() {
		setId(id);// TODO ¿COMO LOGRAR QUE POR DEFECTO SE ASIGNE UN UUID QUE SEA TODO CON 0?
		setTipoIdentificacionDTO(new TipoIdentificacionDTO());
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompletoDTO(nombreCompleto);
		setCorreoElectronicoDTO(correoElectronico);
		setNumeroTelefonoDTO(numeroTelefono);
		setFechaNacimiento(fechaNacimiento);// TODO ¿COMO LOGRAR QUE POR DEFECTO SE ASIGNE UNA FECHA POR DEFECTO QUE NO SEA VALIDA Y QUE SE PUEDA SABER FACILMENTE IDENTIFICARLA?
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
