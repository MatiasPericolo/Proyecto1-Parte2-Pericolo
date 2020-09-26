package Grafo;

import TDALista.Position;

public class Node {
	
	int elemento;
	Position<Node> posicionEnListaNode;
	
	public Node(int elem) {
		elemento=elem;
	}
	
	public int getElemento() {
		return elemento;
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	public Position<Node> getPosicionEnListaNode() {
		return posicionEnListaNode;
	}
	public void setPosicionEnListaNode(Position<Node> posicionEnListaNode) {
		this.posicionEnListaNode = posicionEnListaNode;
	}

}
