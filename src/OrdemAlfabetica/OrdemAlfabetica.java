package OrdemAlfabetica;

import Pilha.Pilha;

public class OrdemAlfabetica {

	private final Pilha pilhaOrdenada;
	private final Pilha pilhaTemporaria;
	
	public OrdemAlfabetica() {
		pilhaOrdenada = new Pilha();
		pilhaTemporaria = new Pilha();
	}

	private boolean nomeDoTopoDaPilhaOrdenadaVemAntes(String nome) {

		String nomeDoTopo = pilhaOrdenada.top().toString();

		return nomeDoTopo.compareTo(nome) < 0;
	}

	private boolean nomeDoTopoDaPilhaInversaVemAntes(String nome) {

		String nomeDoTopo = pilhaTemporaria.top().toString();

		return nomeDoTopo.compareTo(nome) < 0;
	}
	
	public void push(String nome) {
		Pilha pilhaTemporaria = new Pilha();

		while ((pilhaOrdenada.pegaTamanho() > 0) && !nomeDoTopoDaPilhaOrdenadaVemAntes(nome)) {
			pilhaTemporaria.push(pilhaOrdenada.pop());
		}

		pilhaOrdenada.push(nome);

		while (pilhaTemporaria.pegaTamanho() > 0) {
			pilhaOrdenada.push(pilhaTemporaria.pop());
		}

	}

	public String top() {
		return pilhaOrdenada.top().toString();
	}

	public void pop () {
		if(pilhaOrdenada.pegaTamanho() == 0) {
			throw new IllegalArgumentException("Pilha Vazia");
		} else {
			pilhaOrdenada.pop();
		}
		
	}

	public String popTest(){
		String aux;

		if(pilhaOrdenada.pegaTamanho() == 0) {
			throw new IllegalArgumentException("Pilha Vazia");
		} else {
			aux = pilhaOrdenada.pop().toString();
			return aux;
		}
	}
	
	public int getTamanho() {
		return pilhaOrdenada.pegaTamanho();
	}
	
}
