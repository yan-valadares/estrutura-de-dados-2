package Fila;

import ListaLigada.ListaLigada;

public class Fila {

	private ListaLigada fila = new ListaLigada();
	
	public void adicionar(Object novoElemento) {
		fila.adicionaNoFinal(novoElemento);
	}
	
	public void remover () {
		fila.removeDoComeco();
	}
	
	public boolean ehVazia() {
		return fila.ehVazia();
	}
	
	public Object poll() {
		if (ehVazia()) {
			return null;
		}else {
			Object primero_fila = fila.pegaPrimeiro();
			fila.removeDoComeco();
			return primero_fila;
		}
	}
	
	public Object[] toArray() {
		Object[] quantidadeElementosEmCadaMaquina = new Object[fila.pegaTotalElementos()];
		
		for(int i = 0; i < fila.pegaTotalElementos(); i++) {
			quantidadeElementosEmCadaMaquina[i] = fila.pega(i);
		}
		
		return quantidadeElementosEmCadaMaquina;
	}
	
	public boolean contem(Object elementoBuscado) {
		return fila.contem(elementoBuscado);
	}
	
	public int pegaTamanho() {
		return fila.pegaTotalElementos();
	}
	
}






