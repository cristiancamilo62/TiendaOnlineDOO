package co.edu.uco.tiendaonline.service.domain.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.crosscutting.util.UtilUuid;

public final class TipoIdentificacionDomain {
	
	private UUID id;
	private String codigo;
	private String nombre;
	private boolean estado;
	
	public TipoIdentificacionDomain() {
		setId(UtilUuid.obtenerDefectoUUID(id));
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
		setEstado(false);
	}
	
	private TipoIdentificacionDomain(final UUID id, final String codigo, final String nombre, final boolean estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}
	
	public static final TipoIdentificacionDomain crear(final UUID id, final String codigo, final String nombre, final boolean estado) {
		return new TipoIdentificacionDomain(id, codigo, nombre, estado);
	}
	
	public static final TipoIdentificacionDomain crear() {
		return new TipoIdentificacionDomain();
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setEstado(final boolean estado) {
		this.estado = estado;
	}

	public final UUID getId() {
		return id;
	}

	public final String getCodigo() {
		return codigo;
	}

	public final String getNombre() {
		return nombre;
	}

	public final boolean isEstado() {
		return estado;
	}	
	

}
