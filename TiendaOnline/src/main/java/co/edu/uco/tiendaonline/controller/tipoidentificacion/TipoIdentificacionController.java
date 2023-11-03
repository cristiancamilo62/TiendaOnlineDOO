package co.edu.uco.tiendaonline.controller.tipoidentificacion;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.service.dto.TipoIdentificacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Tag(name = "TipoIdentificacionAPI", description = "Ofrece las api de consumo con todas las operaciones relaciones con TipoIdentificación")
public interface TipoIdentificacionController {
	
	@Operation(summary = "Obtener Dummy", description = "Servicio encargado de obtener la estructura basica de un JSON básica de un tipoIdentipicacion")
	TipoIdentificacionDTO obtenerDummy();

	@Operation(summary = "consultar", description = "Servicio que se encarga de obtener todos los tipos de identificacion que cumplen con los parametros de de filtrado")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultar(@RequestBody TipoIdentificacionDTO dto);
	
	@Operation(summary = "consultar PorbId", description = "Servicio que se encarga de obtener la información del tipo de identificacion que cumplen el id parametro del Id")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultarPorId(@PathVariable("id") UUID id);
	
	@Operation(summary = "Registrar", description = "Servicio que se encarga de registrar toda la información de un Tipo de Identificacion")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo de identificacion registrado exitosamente"),
			 @ApiResponse(responseCode = "400", description = "Tipo de identificacion no registrado exitosamente por algun error conocido"),
			 @ApiResponse(responseCode = "500", description = "Tipo de identificacion no registrado exitosamente por un problema desconocido")})		
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) ;
	
	@Operation(summary = "Modificar", description = "Servicio que se encarga de modificar los datos de un tipo de identificacion por medio de el id")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> modificar(@PathVariable("id") UUID id,@RequestBody TipoIdentificacionDTO dto) ;
	
	@Operation(summary = "eliminar", description = "Servicio que se encarga de eliminar la información de un tipo de identificacion por medio del parametro id")
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> eliminar(@PathVariable("id") UUID id) ;


}
