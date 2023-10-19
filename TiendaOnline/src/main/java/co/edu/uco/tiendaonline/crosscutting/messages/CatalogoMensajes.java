package co.edu.uco.tiendaonline.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrosscuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

public class CatalogoMensajes {
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();
	
	static {
		cargarMensajes();
	}

	private CatalogoMensajes() {
		super();
	}
	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No se recibió el"
				+ "código del mensaje que se quería crear. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No existe un"
				+ "mensaje con el código indicado. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No es posible onbtener "
				+ "un mensaje con un codigo vacio o nulo. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se a presentado un problema "
				+ "inesperado tratando de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste, "
				+ "contacte al administrador de la aplicación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema "
				+ "trantando de validar si la conexión SQL estaba abierta. Se presento una excepción de tipo SQLException. Por favor verifique"
				+ "la traza completa del error presentado, para así poder diagnosticar con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema "
				+ "inesperado trantando de validar si la conexión SQL estaba abierta. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000007, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible validar si una conexión "
				+ "esta abierta cuando es nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000008,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible cerrar una conexión "
				+ "que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000009, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible cerrar una conexión "
				+ "que ya esta cerrada. Esto se debe a que una conexión que ha sido terminada o cerrada ya "
				+ "no se encuentra en un estado activo y operativo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000010, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando "
				+ " de cerrar la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para poder diagnosticar "
				+ "con mayor certeza lo que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado"
				+ "trantando de cerrar la conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000012,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible iniciar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000013, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible iniciar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000014, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible iniciar una transacción que ya ha sido"
				+ "iniciada. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000015, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "se ha presentado un problema trantando"
				+ "de iniciar la transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema"
				+ "trantando de iniciar la transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar"
				+ "con mayor certeza lo que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000017,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible confirmar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000018, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible confirmar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000019, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible confirmar una transacción que no ha sido"
				+ "iniciada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000020, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando"
				+ "de confirmar la transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado "
				+ "trantando de confirmar la transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000022,TipoMensaje.TECNICO,CategoriaMensaje.ERROR,"no es posible cancelar una transacción con una"
				+ "conexión que esta nula. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000023, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"no es posible cancelar una transacción con una conexión "
				+ "cerrada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000024, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "no es posible cancelar una transacción que no ha sido"
				+ "iniciada. No es posible continuar con el proceso"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000025, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema trantando"
				+ "de cancelar una transacción de una la conexion SQL. Se presento una excepción de tipo SQLException. Por favor "
				+ "verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado "
				+ "trantando de cancelar una transacción de una conexión SQL. Se presento una excepción generica de tipo Exception. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza lo que sucedio. "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000027, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo toDomain de la clase "
				+ "TipoIdentificacionEntityMapper. No es posible mapear un tipo de Identificación Dominio a partir de una entidad de tipo Identificación entity nula."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000028, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo toEntity de la clase "
				+ "TipoIdentificacionEntityMapper.No es posible mapear un tipo de Identificación Entity a partir de un domain de tipo Identificación entity nula."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000029, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema tratando de llevar a cabo el "
				+ "registro de la inofrmación del nuevo tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000030, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema en el metodo setFactoria de la clase"
				+ " RegistrarTipoIdentificacionUseCase debido a que la factoria con la cual se desea crear esta nula."));
	}
	

	private static void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if(UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario= obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico= obtenerContenidoMensaje(CodigoMensaje.M0000002);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		
		if (!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M0000004);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M0000002);
			throw CrosscuttingTiendaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		
		return MENSAJES.get(codigo);
	}
	
	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
	
	
}
