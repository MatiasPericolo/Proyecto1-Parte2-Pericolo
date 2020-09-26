package TDALista;

/**
 * Class BoundaryViolationException
 * @author Horus Moro, Tomas Scandalitta -- ED 2018.
 */
@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception{
	
	/**
	 * Crea un objeto instancia de BoundaryViolationException.
	 * @param msg Mensaje a mostrar.
	 */
	public BoundaryViolationException(String msg) {
		super(msg);
	}
}
