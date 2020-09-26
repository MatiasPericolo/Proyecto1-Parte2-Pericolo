package TDALista;

/**
 * Class Node
 * @author Horus Moro, Tomas Scandalitta -- ED 2018.
 */
public class Node<E> implements Position<E>{
	private E element;
	private Node<E> next;
	
	/**
	 * Crea un objeto instancia de Node.
	 * @param e Elemento del nodo.
	 */
	public Node(E e) {
		element=e;
		next=null;
	}
	
	/**
	 * Crea un objeto instancia de Node.
	 * @param e Elemento del nodo.
	 * @param n Nodo siguiente.
	 */
	public Node(E e, Node<E> n) {
		element=e;
		next=n;
	}
	
	/**
	 * Devuelve el nodo siguiente.
	 * @return Nodo siguiente.
	 */
	public Node<E> getNext(){
		return next;
	}
	
	/**
	 * Setea el elemento del nodo.
	 * @param ele Elemento a setear.
	 */
	public void setElement(E ele) {
		element=ele;
	}
	
	/**
	 * Setea el nodo siguiente.
	 * @param newNext Nodo siguiente a setear.
	 */
	public void setNext(Node<E> newNext) {
		next=newNext;
	}
	
	public E element() {
		return element;
	}
}