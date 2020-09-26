package TDALista;

public class DNode<E> implements Position<E>{
	private E element;
	private DNode<E> next, prev;
	
	public DNode(DNode<E> newPrev, DNode<E> newNext, E elem){
		prev=newPrev;
		next=newNext;
		element=elem;
	}
	
	public DNode() {
		this(null, null, null);
	}
	
	public E element() {
		return element;
	}
	public DNode<E> getNext(){
		return next;
	}
	public DNode<E> getPrev(){
		return prev;
	}
	public void setNext(DNode<E> newNext) {
		next=newNext;
	}
	public void setPrev(DNode<E> newPrev) {
		prev=newPrev;
	}
	public void setElement(E elem) {
		element=elem;
	}	
}
