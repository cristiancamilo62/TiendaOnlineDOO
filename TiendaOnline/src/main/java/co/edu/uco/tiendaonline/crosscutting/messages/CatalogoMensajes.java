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
				+ "registro de la información del nuevo tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000030, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema en el metodo setFactoria de la clase"
				+ " RegistrarTipoIdentificacionUseCase debido a que la factoria con la cual se desea crear esta nula."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000031, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo setFactoria de la clase"
				+ " RegistrarTipoIdentificacionUseCase debido a que la factoria con la cual se desea crear esta nula."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000032, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de obtener la conexión con SQL Server. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000033, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de obtener la conexión con SQL Server. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de obtener el DAO de ClienteSQLServerDAO debido a que la conexión actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de obtener el DAO de TipoIdentificacionSQLServerDAO debido a que la conexión actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000036, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para PostgreSQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para MySQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000038, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para Oracle no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000039, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos deseada no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000040, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo toDomain de la clase "
				+ "ClienteEntityMapper. No es posible mapear un cliente Dominio a partir de una entidad de cliente entity nula."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema en el metodo toEntity de la clase "
				+ "ClienteEntityMapper. No es posible mapear un cliente Entity a partir de un dominio del cliente nula."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000043, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de registrar un nuevo tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000044, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo execute de la clase RegistrarTipoIdentificacionFacade"
				+ "tratando de registrar Un nuevo tipo de identificacion. Por favor verifique la traza completa del error presentado, para así "
				+ "poder diagnosticar con mayor certeza lo que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000045, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "No es posible realizar la operacion con un cliente nulo"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000046, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "La longitud del correo eléctronico no es valida.La longitud maxima es 40 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000047, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"EL correo eléctronico es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000048, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"EL correo eléctronico no es valido. Por favor validar su formato 'usuario@example.com'"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000049, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La fecha de nacimiento es un dato Obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000050, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La fecha de nacimiento debe tener el formato yyyy-MM-dd"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000051, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La longitud del primer nombre no en valida.La longitud maxima es 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000052, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La longitud del segundo nombre no en valida.La longitud maxima es 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000053, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La longitud del primer apellido no en valida.La longitud maxima es 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000054, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La longitud del segundo apellido no en valida.La longitud maxima es 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000055, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El primer nombre debe tener solo letras o números "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000056, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El segundo nombre debe tener solo letras o números "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000057, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El primer apellido debe tener solo letras o números "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000058, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El segundo apellido debe tener solo letras o números "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000059, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El primer nombre es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000060, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El primer apellido es un dato obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000061, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"La longitud del número de identificacion no en valida.La longitud maxima es 10 caracteres"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000062, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El número de identificacion es obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000063, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El número de identificación solo debe contener numeros"));			
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000064, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El número de telefono del cliente solo debe tener digitos"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000065, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El número de telefono del cliente es un dato Obligatorio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000066, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"El número de telefono del cliente es incorrecto.EL número de digitos debe ser igual a 10 "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000067, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de eliminar la información del "
				+ "tipo de Identificación por el identificador deseado."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000068, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el método eliminar por"
				+ " ID de la clase TipoIdentificaciónSQLServer tratando de ejecutar la sentencia SQL de eliminación "
				+ "del tipo de identificación deseado. Por favor, revise la traza del problema presentado para identificar lo que sucedió."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000069, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Exception en el método eliminar por ID de la clase "
				+ "TipoIdentificaciónSQLServer tratando de ejecutar la sentencia SQL de eliminación del tipo de identificación deseado."
				+ " Por favor, revise la traza del problema presentado para identificar lo que sucedió."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000070, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de modificar la información del Tipo de identificación."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000071, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el método modificar de la clase TipoIdentificaciónSQLServer"
				+ " tratando de ejecutar la sentencia SQL de modificación del tipo de identificación deseado. Por favor, revise la traza del problema "
				+ "presentado para identificar lo que sucedió."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000072, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Exception en el método modificar de la clase TipoIdentificaciónSQLServer tratando de ejecutar la sentencia S"
				+ "QL de modificación del tipo de identificación deseado. Por favor, revise la traza del problema presentado para identificar lo que sucedió."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000073, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema trantando de eliminar la información de un"
				+ "tipo de Identificación...."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000074, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo eliminar de la clase"
				+ "TipoIdentificaciónSQLServerDAO tratando de llevar a cabo la eliminación de un TipoIdentificacion."
				+ "Por favor revise la traza del problema presentado para así, poder identificar que sucedio "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000075, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo Excepcion en el metodo eliminar de la clase"
				+ "TipoIdentificaciónSQLServerDAO tratando de llevar a cabo la eliminación de un TipoIdentificacion."
				+ "Por favor revise la traza del problema presentado para así poder identificar el problema"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000076, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema trantando de consultar la información del Tipo de identificación"
				+ "por el identificador deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000077, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema, de tipo SQLExcepcion en el metodo consultar por id de la clase"
				+ "TipoIdentificaciónSQLServer tratando de preparar la sentencia SQL de la consulta del tipo de identificación deseado."
				+ "por favor revise la traza del problema presentado para así poder identificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000078,TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo consultar por id de la clase"
				+ "TipoIdentificaciónSQLServer tratando de preparar la sentencia SQL de la consulta del tipo de identificación deseado."
				+ "por favor revise la traza del problema presentado para así poder identificar que sucedio"));
		
		
		
		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000079, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"organizar"));
		
		
		
		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000080, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo consultar por id de la clase"
				+ "TipoIdentificaciónSQLServer, tratando de recuperar los datos de la consulta del tipo de identificación deseada."
				+ "por favor revise el problema presentado para así poder identificar que sucedio...."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000081, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado, de tipo Excepcion en el metodo consultar por id de la clase"
				+ "TipoIdentificaciónSQLServer tratando de recuperar los datos de la consulta del tipo de identificación deseada."
				+ "por favor revise el problema presentado, para así poder identificar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000082, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema, trantando de llevar a cabo la consulta de los Tipos de identificación.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000083, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo prepararEjecutarSentenciaConsulta de la clase TipoIdentificacionSQLServerDAO"
				+ "tratando de preparar la sentencia SQL."
				+ "por favor revise el problema presentado para así poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000084, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion en el metodo prepararEjecutarSentenciaConsulta de la clase TipoIdentificacionSQLServerDAO"
				+ "tratando de preparar la sentencia SQL."
				+ "por favor revise el problema presentado para así poder identificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000085, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema, trantando de llevar a cabo la consulta de los Tipos de identificación.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000086, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo colocarParametrosconsulta de la clase TipoIdentificacionSQLServerDAO"
				+ "tratando de colocar los parametros de la consulta del tipo de identificación deseada..."
				+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000087, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion en el metodo colocarParametrosconsulta de la clase TipoIdentificacionSQLServerDAO"
				+ "tratando de colocar los parametros de la consulta del tipo de identificación deseada."
				+ "por favor revise el problema presentado para así poder identificar que sucedio...."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000088, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema, trantando de consultar la información "
				+ "del tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000089, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo ejecutarConsulta de la clase"
				+ "TipoIdentificaciónSQLServerDAO tratando de recuperar los datos de la consulta del tipo de identificación deseada."
				+ "Por favor revise el problema presentado para así poder identificar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000090, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion en el metodo consultar por id de la clase"
				+ "TipoIdentificaciónSQLServer tratando de recuperar los datos de la consulta del tipo de identificación deseada."
				+ "por favor revise el problema presentado para así poder identificar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000091, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de crear un nuevo cliente."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000092, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el método crear de la clase ClienteSQLServer tratando de ejecutar la sentencia SQL de creación de cliente. "
				+ "Por favor, revise la traza del problema presentado para identificar lo que sucedió."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000093, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Exception en el método crear de la clase ClienteSQLServer tratando"
				+ " de ejecutar la sentencia SQL de creación de cliente. Por favor, revise la traza del problema presentado para identificar lo que sucedió."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000094, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema trantando de eliminar la información de un"
				+ "Cliente...."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000095, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo eliminar de la clase"
				+ "ClienteSQLServerDAO tratando de llevar a cabo la eliminación de un cliente."
				+ "Por favor revise la traza del problema presentado para así poder identificar que sucedio "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000096, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo Excepcion en el metodo eliminar de la clase"
				+ "ClienteSQLServerDAO tratando de llevar a cabo la eliminación de un cliente."
				+ "Por favor revise la traza del problema presentado para así poder identificar que sucedio "));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000097, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema trantando de consultar la información del Cliente"
				+ "por el identificador deseado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000098, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo consultar por id de la clase"
				+ "ClienteSQLServerDAO tratando de preparar la sentencia SQL de la consulta del cliente deseado."
				+ "por favor revise la traza del problema presentado para así poder identificar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000099,TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo consultar por id de la clase"
				+ "ClienteSQLServerDAO tratando de preparar la sentencia SQL de la consulta del cliente deseado."
				+ "por favor revise la traza del problema presentado para así poder identificar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000100, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo consultar por id de la clase"
				+ "ClienteSQLServerDAO,tratando de recuperar los datos de la consulta del cliente deseada..."
				+ "por favor revise el problema presentado para así poder identificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000101, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo Excepcion en el metodo consultar por id de la clase"
				+ "ClienteSQLServerDAO tratando de recuperar los datos de la consulta del cliente deseada"
				+ "por favor revise el problema presentado, para así poder identificar que sucedio"));
	
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000102, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de modificar la información del cliente."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000103, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el método modificar de la clase ClienteSQLServer"
				+ " tratando de ejecutar la sentencia SQL de modificación del cliente deseado. Por favor, revise la traza del problema "
				+ "presentado para identificar lo que sucedió."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000104, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Exception en el método modificar de la clase clienteSQLServer tratando de ejecutar la sentencia S"
				+ "QL de modificación del cliente deseado. Por favor, revise la traza del problema presentado para identificar lo que sucedió."));
		
	
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000105, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema, trantando de llevar a cabo la consulta de los Clientes.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000106, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo Consultar de la clase ClienteSQLServerDAO"
				+ "tratando de preparar la sentencia SQL."
				+ "por favor revise el problema presentado para así poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000107, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion en el metodo Consultar de la clase ClienteSQLServerDAO"
				+ "tratando de preparar la sentencia SQL."
				+ "por favor revise el problema presentado para así poder identificar que sucedio.."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000108, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo colocarParametrosconsulta de la clase ClienteSQLServerDAO"
				+ "tratando de colocar los parametros de la consulta del cliente deseada..."
				+ "por favor revise el problema presentado para así poder identificar que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000109, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion en el metodo colocarParametrosconsulta de la clase ClienteSQLServerDAO"
				+ "tratando de colocar los parametros de la consulta del cliente deseada."
				+ "por favor revise el problema presentado para así poder identificar que sucedio...."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000110, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLExcepcion en el metodo ejecutarConsulta de la clase"
				+ "ClienteSQLServerDAO tratando de recuperar los datos de la consulta del cliente deseada."
				+ "por favor revise el problema presentado para así poder identificar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000111, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado de tipo Excepcion en el metodo ejecutarConsulta de la clase"
				+ "ClienteSQLServerDAO tratando de recuperar los datos de la consulta del cliente deseada."
				+ "por favor revise el problema presentado para así poder identificar que sucedio"));
		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000112, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema tratando de llevar a cabo la "
				+ "modificacion de la información del nuevo tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000113, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema en el metodo setFactoria de la clase"
				+ " ModificarTipoIdentificacionUseCase debido a que la factoria con la cual se desea crear esta nula."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000114, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de modificar un tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000115, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo execute de la clase ModificarTipoIdentificacionFacade"
				+ "tratando de modificar un tipo de identificacion. Por favor verifique la traza completa del error presentado, para así "
				+ "poder diagnosticar con mayor certeza lo que sucedio."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000116, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de eliminar un tipo de identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000117, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo execute de la clase EliminarTipoIdentificacionFacade"
				+ "tratando de eliminar un tipo de identificacion. Por favor verifique la traza completa del error presentado, para así "
				+ "poder diagnosticar con mayor certeza lo que sucedio."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000118, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema tratando de llevar a cabo el "
				+ "registro de la información del nuevo cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000119, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema en el metodo setFactoria de la clase"
				+ " RegistrarClientUseCase debido a que la factoria con la cual se desea crear esta nula."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000120, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de registrar un nuevo cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000121, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo execute de la clase RegistrarClienteFacade"
				+ "tratando de registrar Un nuevo cliente. Por favor verifique la traza completa del error presentado, para así "
				+ "poder diagnosticar con mayor certeza lo que sucedio."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000122, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de eliminar un nuevo cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000123, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo execute de la clase EliminarClienteFacade"
				+ "tratando de eliminar Un nuevo cliente. Por favor verifique la traza completa del error presentado, para así "
				+ "poder diagnosticar con mayor certeza lo que sucedio."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000124, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de modificar un nuevo cliente"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000125, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Excepcion en el metodo execute de la clase ModioficarClienteFacade"
				+ "tratando de modificar un cliente. Por favor verifique la traza completa del error presentado, para así "
				+ "poder diagnosticar con mayor certeza lo que sucedio."));
	
	
	
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
