package TDALista;

/**
 * Class InvalidPositionException
 * @author Horus Moro, Tomas Scandalitta -- ED 2018.
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception{
	
	/**
	 * Crea un objeto instancia de InvalidPositionList.
	 * @param msg Mensaje a mostrar.
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}
}