package co.edu.uco.tiendaonline.controller.cliente;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.tiendaonline.controller.support.response.Respuesta;
import co.edu.uco.tiendaonline.crosscutting.exception.TiendaOnlineException;
import co.edu.uco.tiendaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.tiendaonline.service.dto.ClienteDTO;
import co.edu.uco.tiendaonline.service.facade.concrete.cliente.ConsultarClienteFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.cliente.ConsultarPorIdClienteFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.cliente.EliminarClienteFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.cliente.ModificarClienteFacade;
import co.edu.uco.tiendaonline.service.facade.concrete.cliente.RegistrarClienteFacade;
import co.edu.uco.tiendaonline.service.mapper.dto.concrete.ClienteDTOMapper;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	
	@GetMapping("/dummy")
	public final ClienteDTO obtenerDummy() {
		return ClienteDTO.crear();
	}
	

	@PostMapping()
	public final ResponseEntity<Respuesta<ClienteDTO>> registrar(@RequestBody ClienteDTO dto) {
		
		final Respuesta<ClienteDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			RegistrarClienteFacade facade = new RegistrarClienteFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente se ha registrado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de resgistrar el nuevo Cliente");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	@DeleteMapping("/{id}")
	public final ResponseEntity<Respuesta<ClienteDTO>> eliminar(@PathVariable("id") UUID id) {
		final Respuesta<ClienteDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			var domain =  ClienteDomain.crear(id, null, null, null, null, null, null);
			ClienteDTO dto = ClienteDTOMapper.convertToDTO(domain);
			
			EliminarClienteFacade facade = new EliminarClienteFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente se ha eliminado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de eliminar el cliente");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	@PutMapping("{id}")
	public final ResponseEntity<Respuesta<ClienteDTO>> modificar(@PathVariable("id") UUID id,@RequestBody ClienteDTO dto) {
		final Respuesta<ClienteDTO> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			
			ModificarClienteFacade facade = new ModificarClienteFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente se ha modificado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de modificar el cliente");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	@GetMapping("/{id}")
	public final ResponseEntity<Object> consultarPorId(@PathVariable("id") UUID id) {
		
		final Respuesta<Object> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		
		try {
			
			var domain =  ClienteDomain.crear(id, null, null, null, null, null, null);
			ClienteDTO dto = ClienteDTOMapper.convertToDTO(domain);
			
			ConsultarPorIdClienteFacade facade = new ConsultarPorIdClienteFacade();
			 respuesta.getDatos().add(facade.executeRetorno(dto));
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente se ha consultado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de consultar el cliente");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	@GetMapping
	public final ResponseEntity<Object> consultar(@RequestBody ClienteDTO dto) {
		
		final Respuesta<Object> respuesta = new Respuesta<>();
		
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		
		try {
			ConsultarClienteFacade facade = new ConsultarClienteFacade();
			
			respuesta.getDatos().add(facade.executeRetorno(dto)) ;
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El cliente se ha consultado exitosamente");
			
		} catch (final TiendaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExceptionRaiz().printStackTrace();
			//TODO: hacer logger de la excepcion
			
		}catch (final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema tratando de consultar el cliente");
			excepcion.printStackTrace();
			//TODO: hacer logger de la excepcion
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	


}
