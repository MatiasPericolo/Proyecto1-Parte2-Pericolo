package TDALista;

import java.util.Iterator;

public class DoubleLinkedList<E> implements PositionList<E> {
	protected DNode<E> header, trailer;
	protected int size;
	
	public DoubleLinkedList() {
		size=0;
		header= new DNode<E>();
		trailer= new DNode<E>(header, null, null);
		header.setNext(trailer);		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public Position<E> first() throws EmptyListException{
		if(size==0)
			throw new EmptyListException("Lista vacia");
		return header.getNext();
	}
	public Position<E> last() throws EmptyListException{
		if(size==0)
			throw new EmptyListException("Lista vacia");
		return trailer.getPrev();
	}
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> n= checkPosition(p);
		DNode<E> prev= n.getPrev();
		if(prev==header)
			throw new BoundaryViolationException("No se le puede pedir el anterior al primero");
		return prev;
	}
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNode<E> n= checkPosition(p);
		DNode<E> next= n.getNext();
		if(next==trailer)
			throw new BoundaryViolationException("No se le puede pedir el siguiente al ultimo");
		return next;
	}
	public void addFirst(E e) {
		DNode<E> n= new DNode<E>(header, header.getNext(), e);
		header.getNext().setPrev(n);
		header.setNext(n);
		size++;
	}
	public void addLast(E e) {
		DNode<E> n= new DNode<E>(trailer.getPrev(), trailer, e);
		trailer.getPrev().setNext(n);
		trailer.setPrev(n);
		size++;
	}
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		DNode<E> n= checkPosition(p);
		DNode<E> newNode= new DNode<E>(n, n.getNext(), e);
		n.getNext().setPrev(newNode);
		n.setNext(newNode);
		size++;
	}
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		DNode<E> n= checkPosition(p);
		DNode<E> newNode= new DNode<E>(n.getPrev(), n, e);
		n.getPrev().setNext(newNode);
		n.setPrev(newNode);
		size++;
	}
	public E remove(Position<E> p) throws InvalidPositionException{
		if(size==0)
			throw new InvalidPositionException("lista vacia");
		DNode<E> n= checkPosition(p);
		DNode<E> nPrev= n.getPrev();
		DNode<E> nNext= n.getNext();
		nPrev.setNext(nNext);
		nNext.setPrev(nPrev);
		E elem= n.element();
		size--;
		n=null;
		return elem;
	}
	public E set(Position<E> p, E ele) throws InvalidPositionException{
		if(size==0)
			throw new InvalidPositionException("lista vacia");
		DNode<E> n= checkPosition(p);
		E viejo= n.element();
		n.setElement(ele);
		return viejo;
	}
	private DNode<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p==null)
			throw new InvalidPositionException("posicion nula");
		if(p==header)
			throw new InvalidPositionException("El header no es posicion valida");
		if(p==trailer)
			throw new InvalidPositionException("El trailer no es posicion valida");
		try {
			DNode<E> temp= (DNode<E>) p;
			if((temp.getPrev()==null) || (temp.getNext()==null))
				throw new InvalidPositionException("p no pertenece a la lista");
			return temp;
		}
		catch(ClassCastException e) {
			throw new InvalidPositionException("error de cast");
		}
		
	}
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> iterable = new DoubleLinkedList<Position<E>>();
		try {
			if(size>0) {
				Position<E> p= first();
				while(p!=null) {
					iterable.addLast(p);
					p= p==last() ? null : next(p);
				}
			}
		}
		catch(EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			System.out.println(e.getMessage());
		}
		return iterable;
	}
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}
	
	public DoubleLinkedList<E> clonar(){
		DoubleLinkedList<E> lista= new DoubleLinkedList<E>();
		for(E e : this)
			lista.addLast(e);
		return lista;
	}
}