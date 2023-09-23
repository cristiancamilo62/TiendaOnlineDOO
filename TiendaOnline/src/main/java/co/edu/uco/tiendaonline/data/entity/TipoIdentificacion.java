package co.edu.uco.tiendaonline.data.entity;

import java.util.UUID;

public final class TipoIdentificacion {
	
	private UUID id;
	private String codigo;
	private String nombre;
	private boolean estado;
	
	private TipoIdentificacion(final UUID id, final String codigo, final String nombre, final boolean estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}
	public static final TipoIdentificacion crear(final UUID id, final String codigo, final String nombre, final boolean estado) {
		return new TipoIdentificacion(id, codigo, nombre, estado);
	}

	public final UUID getId() {
		return id;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	public final String getCodigo() {
		return codigo;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public final boolean isEstado() {
		return estado;
	}

	private final void setEstado(final boolean estado) {
		this.estado = estado;
	}
	
	
}
