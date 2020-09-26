package TDALista;

/**
 * Class EmptyListException
 * @author Horus Moro, Tomas Scandalitta -- ED 2018.
 */
@SuppressWarnings("serial")
public class EmptyListException extends Exception{
	
	/**
	 * Crea un objeto instancia de EmptyListException.
	 * @param msg Mensaje a mostrar.
	 */
	public EmptyListException(String msg) {
		super(msg);
	}
}