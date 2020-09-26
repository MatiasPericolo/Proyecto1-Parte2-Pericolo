package Grafo;

import TDALista.Position;

public class Arco {
	
	Node desde,hasta;
	Position<Arco> posicionEnListaArcos;
	
	public Arco(Node node1,Node node2) {
		desde=node1;
		hasta=node2;
	}

	public Node getDesde() {
		return desde;
	}

	public void setDesde(Node desde) {
		this.desde = desde;
	}

	public Node getHasta() {
		return hasta;
	}

	public void setHasta(Node hasta) {
		this.hasta = hasta;
	}

	public Position<Arco> getPosicionEnListaArcos() {
		return posicionEnListaArcos;
	}

	public void setPosicionEnListaArcos(Position<Arco> posicionEnListaArcos) {
		this.posicionEnListaArcos = posicionEnListaArcos;
	}

}
