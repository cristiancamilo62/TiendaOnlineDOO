package co.edu.uco.tiendaonline.service.businesslogic;

public interface UseCase<D>{
	
	void execute(D domain);
	

}
