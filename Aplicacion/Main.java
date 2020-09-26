package Aplicacion;

import Grafo.Graph;
import TDALista.BoundaryViolationException;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;



public class Main {

	public static void main(String[] args) throws EmptyListException, InvalidPositionException, BoundaryViolationException {
		Graph grafo=new Graph();
		
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addEdge(2, 3);
		grafo.removeEdge(2,4);
		grafo.removeNode(2);//Remove node remueve el arco 2/3
		grafo.addNode(3);
		
		grafo.usarLogger();
		
	}
}
