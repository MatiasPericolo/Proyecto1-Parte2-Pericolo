package Grafo;

import java.util.logging.*;

import TDALista.BoundaryViolationException;
import TDALista.DoubleLinkedList;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.Position;
import TDALista.PositionList;

public class Graph {

	protected PositionList<Node> nodos;
	protected PositionList<Arco> arcos;
	private static Logger logger;
	
	public Graph() {
		nodos=(DoubleLinkedList<Node>) new DoubleLinkedList();
		arcos=(DoubleLinkedList<Arco>) new DoubleLinkedList();
		
		if (logger == null){
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.FINE);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	
	/*Agrega el nodo “node” al grafo, si aún no pertenecía a la
	estructura.*/
	public void addNode(int node) {
		boolean crear=true;
		
		for(Node n:nodos) {
			if(n!=null)
				if(n.getElemento()==node) {
					logger.warning("Existe un Nodo "+node+" ya perteneciente a la Estructura.");
					crear=false;
				}
		}
		
		if(crear) {
			Node nuevoNodo=new Node(node);
			nodos.addLast(nuevoNodo);
			logger.fine("Nodo "+node+" creado exitosamente.");
		}
	}
	
	/*agrega un arco entre el nodo “node1” y el nodo
	“node2”, si aún no existía el arco y ambos parámetros son nodos pertenecientes a la
	estructura.*/
	public void addEdge(int node1, int node2) {
		boolean crear=true;
		Node nodoDesde = null,nodoHasta = null;
		
		for(Node n:nodos) {
			if(n!=null)
				if(n.getElemento()==node1) {
					nodoDesde=n;
				}else if(n.getElemento()==node2) {
					nodoHasta=n;
				}
		}
		
		if(nodoDesde==null || nodoHasta==null) {
			logger.warning("No se puede crear un arco entre Nodos no existentes.");
		}else {
			for(Arco a:arcos){
				if(a!=null)
					if(a.getDesde().getElemento()==node1 && a.getHasta().getElemento()==node2) {
						logger.warning("El Arco que se quiere crear ya existe en la estructura.");
						crear=false;
					}
			}
			
			if(crear) {
				Arco arcoNuevo=new Arco(nodoDesde,nodoHasta);
				arcos.addLast(arcoNuevo);
				logger.fine("Arco entre "+node1+" y "+node2+" creado exitosamente");
			}
		}
	}
	
	/*remueve el nodo “node” del grafo, si el parámetro es un
	nodo de la estructura.*/
	public void removeNode(int node) throws EmptyListException, InvalidPositionException, BoundaryViolationException {
			if(nodos.isEmpty()) {
				logger.warning("El Nodo "+node+" que quiso eliminar, no existe.");
			}else {
				
				Position<Node> buscador=nodos.first();
				boolean encontre=false;
				
				while(buscador.element()!=null && !encontre) {
					if(buscador.element().getElemento()==node) {
						encontre=true;
						
						for(Arco a:arcos) {
							if(a.getDesde().getElemento()==node || a.getHasta().getElemento()==node) {
								removeEdge(a.getDesde().getElemento(),a.getHasta().getElemento());
							}
						}
						
						nodos.remove(buscador);
						logger.fine("Nodo "+node+" eliminado correctamente.");
					}
					if(buscador!=nodos.last() && !encontre)
						buscador=nodos.next(buscador);
				}
				if(!encontre)
					logger.warning("El Nodo "+node+" que quiso eliminar, no existe.");
				
			}
			
	}
	
	/*remueve el arco entre el nodo “node1” y el
	nodo “node2”, si el arco formado por los parámetros pertenecen a la estructura.*/
	public void removeEdge(int node1, int node2) throws InvalidPositionException, EmptyListException, BoundaryViolationException {
			if(arcos.isEmpty()) {
				logger.warning("No existe el Arco entre "+node1+" y "+node2+" que se quiere eliminar.");
			}else {
				Position<Arco> buscador=arcos.first();
				boolean encontre=false,fin=false;
				
				while(!fin && !encontre) {
					if(buscador.element().getDesde().getElemento()==node1 && buscador.element().getHasta().getElemento()==node2) {
						encontre=true;
						
						arcos.remove(buscador);
						logger.fine("Arco entre "+node1+" y "+node2+" eliminado correctamente.");
						
					}else if(!encontre) {
						if(buscador.equals(arcos.last())) 
							fin=true;
						else
							buscador=arcos.next(buscador);
					}
				}
				
				if(!encontre) {
					logger.warning("No existe el Arco entre "+node1+" y "+node2+" que se quiere eliminar.");
				}
			}			
	}
	
}
