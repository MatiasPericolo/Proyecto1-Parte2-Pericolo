package TDALista;

import java.util.Iterator;

/**
 * Class LinkedList
 * @author Horus Moro, Tomas Scandalitta -- ED 2018.
 */
public class LinkedList<E> implements PositionList<E> {
	
	protected Node<E> head;
	protected int longitud;
	
	/**
	 * Crea un objeto instancia de LinkedList.
	 */
	public LinkedList() {
		head=null;
		longitud=0;
	}
	
	public int size() {
		return longitud;
	}
	
	public boolean isEmpty() {
		return longitud==0;
	}
	
	public Position<E> first() throws EmptyListException{
		if (longitud==0)throw new EmptyListException("Lista Vacia");
		else 
			return head;
	}
	
	public Position<E>last()throws EmptyListException{
		if(longitud==0)
			throw new EmptyListException("Lista Vacia");
		else {
			Node<E> aux= head;
			while(aux.getNext()!=null) 
				aux = aux.getNext();
			return aux;
		}
	}
	
	public Position<E> prev(Position<E> p)throws InvalidPositionException, BoundaryViolationException{
		try {	
			if(p==first())
				throw new BoundaryViolationException("Lista::prev(): "+"Posición primera");
		}
		catch(EmptyListException e) {
			e.getMessage();
		}
		Node<E> n= checkPosition(p);
		Node<E> aux= head;
		while(aux.getNext()!=n && aux.getNext()!=null) {
			aux= aux.getNext();
		}	
		if(aux.getNext()==null)
			throw new InvalidPositionException( "Lista::prev(): " +"Posicion no pertenece a la lista" );
		return aux;
	}
	
	private Node<E> checkPosition(Position<E>p)throws InvalidPositionException{
		try {
			if(p == null)
				throw new InvalidPositionException("Pos Nula");
			return (Node<E>) p;
		} 
		catch( ClassCastException e ) {
			throw new InvalidPositionException("Error de casteo");
		}
	
	}
	
	public void addFirst(E e){
		head=new Node<E>(e,head);
		longitud++;
	}
	
	public void addLast(E e){
		if(longitud==0) {
			addFirst(e);
		}
		else {
			Node<E>p=head;
			while(p.getNext()!=null) {
				p=p.getNext();
			}
			p.setNext(new Node<E>(e));
			longitud++;
		}
	}
	
	public void addAfter(Position<E> p,E e)throws InvalidPositionException {
		Node<E> n=checkPosition(p);
		Node<E> nuevo=new Node<E>(e);
		nuevo.setNext(n.getNext());
		n.setNext(nuevo);
		longitud++;
	}
	
	public void addBefore(Position<E> p, E e )throws InvalidPositionException{
		Node<E> n = checkPosition(p);
		try {
			if(p==first()) {
				addFirst(e);
				longitud++;
			}
			else {
				Node<E> nuevo = new Node<E>(e,n);
				Node<E> anterior = (Node<E>)prev(p);
				anterior.setNext(nuevo);
				longitud++;
			}
		}
		catch(BoundaryViolationException t) {
			throw new InvalidPositionException("Pos Invalida");
		}
		catch(EmptyListException y) {
			throw new InvalidPositionException("Lista Vacia");
		}
	}
	
	public E remove(Position<E> p)throws InvalidPositionException{
		if (longitud==0) 
			throw new InvalidPositionException("Pos invalida");
		Node<E> n= checkPosition(p);
		E aux= p.element();
		if(n==head) {
			head=head.getNext();
			longitud--;
		}
		else {
			try {	
				Node<E> anterior=(Node<E>)prev(p);
				anterior.setNext(n.getNext());
				longitud--;
			}
			catch(BoundaryViolationException e) {
				throw new InvalidPositionException("...");
			}
		}
		return aux;
	}
	
	public E set(Position<E> p,E e)throws InvalidPositionException {
		if(longitud==0)
			throw new InvalidPositionException("Lista Vacia");
		Node<E> n= checkPosition(p);
		E viejo= n.element();
		n.setElement(e);
		return viejo;
	}
	
	public Position<E> next( Position<E> p ) throws InvalidPositionException, BoundaryViolationException {
			Node<E> n = checkPosition(p);
			if(n.getNext()==null)
				throw new BoundaryViolationException("No se le puede pedir next al ultimo");
			return n.getNext();
	}
	
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
	
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> iterable = new LinkedList<Position<E>>();
		if(longitud>0) {
			Node<E>n= head;
			while(n!=null) {
				iterable.addLast(n);
				n=n.getNext()==null? null: n.getNext();
			}
		}
		return iterable;
	}
}