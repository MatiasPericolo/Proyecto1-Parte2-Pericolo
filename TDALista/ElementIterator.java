package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ElementIterator
 * @author Horus Moro, Tomas Scandalitta -- ED 2018.
 */
public class ElementIterator<E> implements Iterator<E>{
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Crea un objeto instancia de ElementIterator.
	 * @param l Lista sobre la cual se va a iterar.
	 */
	public ElementIterator(PositionList<E> l) {
		try {
			list=l;
			cursor= (list.isEmpty())? null : list.first();
		}
		catch (EmptyListException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean hasNext() {
		return cursor!=null;
	}
	
	public E next() throws NoSuchElementException{
		if(cursor==null)
			throw new NoSuchElementException("no tiene siguiente");
		E toReturn= cursor.element();
		try {
			cursor= (cursor==list.last()) ? null : list.next(cursor);
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			System.out.println(e.getMessage());
		}
		return toReturn;
	}

}
