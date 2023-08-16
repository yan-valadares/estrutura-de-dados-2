package Pilha;

import ListaLigada.ListaLigada;

public class Pilha {
	
	private ListaLigada pilha = new ListaLigada();
	
	public void push (Object novoElemento) {
		pilha.adicionaNoFinal(novoElemento);
	}
	
	public Object pop() {
		Object aux;
		aux = pilha.pegaUltima();
		pilha.removeDoFinal();
		
		return aux;
	}
	
	public Object top() {
		return pilha.pegaUltima();
	}
	
	public int pegaTamanho() {
		return pilha.pegaTotalElementos();
	}
	
	public boolean contem(Object elementoBuscado) {
		return pilha.contem(elementoBuscado);
	}

}
