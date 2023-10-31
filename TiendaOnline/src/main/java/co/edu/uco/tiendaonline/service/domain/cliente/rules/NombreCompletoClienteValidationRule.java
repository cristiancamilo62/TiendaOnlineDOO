package co.edu.uco.tiendaonline.service.domain.cliente.rules;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.ServiceTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilTexto;
import co.edu.uco.tiendaonline.service.domain.ValidationRule;
import co.edu.uco.tiendaonline.service.domain.cliente.support.NombreCompletoClienteDomain;

public final class NombreCompletoClienteValidationRule implements ValidationRule<NombreCompletoClienteDomain>{
	
	private static final ValidationRule<NombreCompletoClienteDomain> instancia = new NombreCompletoClienteValidationRule();
	
	public NombreCompletoClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NombreCompletoClienteDomain dato) {
		instancia.validar(dato);
	}
	

	@Override
	public final void validar(final NombreCompletoClienteDomain dato) {
		validarObligatoriedad(dato);
		validarLongitud(dato);
		validarFormato(dato);
	}

	
	public final void validarLongitud(final NombreCompletoClienteDomain dato) {
		validarLongitudPrimerNombre(dato);
		validarLongitudSegundoNombre(dato);
		validarLongitudPrimerApellido(dato);
		validadLongitudSegundoApellido(dato);
		
	}
	private final void validarLongitudPrimerNombre(final NombreCompletoClienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getPrimerNombre(),10)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000051);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarLongitudSegundoNombre(final NombreCompletoClienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getSegundoNombre(),10)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000052);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarLongitudPrimerApellido(final NombreCompletoClienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getPrimerApellido(),10)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000053);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}

	private final void validadLongitudSegundoApellido(final NombreCompletoClienteDomain dato) {
		if(!UtilTexto.longitudMaximaValida(dato.getSegundoApellido(),10)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000054);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
		
	
	private final void validarFormato(final NombreCompletoClienteDomain dato) {
		validarFormatoPrimerNombre(dato);
		validarFormatoSegundoNombre(dato);
		validarFormatoPrimerApellido(dato);
		validarFormatoSegundoApellido(dato);
	}

	private final void validarFormatoPrimerNombre(final NombreCompletoClienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getPrimerNombre())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000055);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}

	private final void validarFormatoSegundoNombre(final NombreCompletoClienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getSegundoNombre())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000056);
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarFormatoPrimerApellido(final NombreCompletoClienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getPrimerApellido())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000057) ;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarFormatoSegundoApellido(final NombreCompletoClienteDomain dato) {
		if(!UtilTexto.contieneSoloLetrasDigitos(dato.getSegundoApellido())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000058) ;
			throw ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarObligatoriedad(final NombreCompletoClienteDomain dato) {
		validarObligatoriedadPrimerNombre(dato);
		validarObligatoriedadPrimerApellido(dato);
		
	}

	private final void validarObligatoriedadPrimerNombre(final NombreCompletoClienteDomain dato) {
		if(UtilTexto.estaVacio(dato.getPrimerNombre())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000059);
			ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
		
	}

	private final void validarObligatoriedadPrimerApellido(final NombreCompletoClienteDomain dato) {
		if(UtilTexto.estaVacio(dato.getPrimerApellido())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M0000060) ;
			ServiceTiendaOnlineException.crear(mensajeUsuario);
		}
	}
	
}
