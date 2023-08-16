package ControleDeProducao;

import Fila.Fila;

public class ControleDeProducao {	
	private Fila maquinaUm;
	private Fila maquinaDois;
	private Fila maquinaTres;
	private int pecasProduzidas =  0;
	private int pecasFinalizadas = 0;
		
	public ControleDeProducao() {
		this.maquinaUm = new Fila();
		this.maquinaDois = new Fila();
		this.maquinaTres = new Fila();
	}
		
	public void adicionarPecas(int numeroPecas) {
		for (int i = 0; i < numeroPecas; i++) {
			this.pecasProduzidas++;
			maquinaUm.adicionar(pecasProduzidas);
		}
	}
	
	public Object[] retornaIdPecas(int numeroMaquina) {
		switch (numeroMaquina) {
		case 1:
			Object[] quantidadeElementosMaquinaUm = maquinaUm.toArray();
			
			return quantidadeElementosMaquinaUm;
		case 2:
			Object[] quantidadeElementosMaquinaDois = maquinaDois.toArray();
			
			return quantidadeElementosMaquinaDois;
		case 3:
			Object[] quantidadeElementosMaquinaTres = maquinaTres.toArray();
			
			return quantidadeElementosMaquinaTres;
		default:
			throw new IllegalArgumentException("Máquina não existe");
	}
	}
	
	public void producaoCompleta(int numeroPecas) {
		this.adicionarPecas(numeroPecas);
		processarPecas(1);
		processarPecas(2);
		processarPecas(3);
	}
	
	public int getNumeroPecasFinalizadas() {
		return this.pecasFinalizadas;
	}
	
	public int getNumeroPecasProduzidas() {
		return this.pecasProduzidas;
	}
	
	private boolean verificarPecasParaSeremProcessadas(int numeroMaquina) {
		
		switch (numeroMaquina) {
			case 1:
				int quantidadeElementosMaquinaUm = maquinaUm.pegaTamanho();
				
				return quantidadeElementosMaquinaUm > 0;
			case 2:
				int quantidadeElementosMaquinaDois = maquinaDois.pegaTamanho();
				
				return quantidadeElementosMaquinaDois > 0;
			case 3:
				int quantidadeElementosMaquinaTres = maquinaTres.pegaTamanho();
				
				return quantidadeElementosMaquinaTres > 0;
			default:
				return false;
		}
	}
	
	private void statusMaquinas() {
		
		int quantidadeElementosMaquinaUm = maquinaUm.pegaTamanho();
		int quantidadeElementosMaquinaDois = maquinaDois.pegaTamanho();
		int quantidadeElementosMaquinaTres = maquinaTres.pegaTamanho();
		int pecasEmProcessoDeProducao = this.pecasProduzidas - this.pecasFinalizadas;
		
		System.out.println("Quantidade de elementos na máquina um: " + quantidadeElementosMaquinaUm);
		System.out.println("Quantidade de elementos na máquina dois: " + quantidadeElementosMaquinaDois);
		System.out.println("Quantidade de elementos na máquina tres: " + quantidadeElementosMaquinaTres);
		System.out.println("Quantidade de peças em produção: " + pecasEmProcessoDeProducao);
		System.out.println("Quantidade de peças finalizadas: " + this.pecasFinalizadas);
	}
		
	public int[] retornarTotalDePecasEmCadaMaquina() {
		int[] quantidadeElementosEmCadaMaquina = new int[3];
		
		quantidadeElementosEmCadaMaquina[0] = maquinaUm.pegaTamanho();
		quantidadeElementosEmCadaMaquina[1] = maquinaDois.pegaTamanho();
		quantidadeElementosEmCadaMaquina[2] = maquinaTres.pegaTamanho();
		
		return quantidadeElementosEmCadaMaquina;
		
	}
	
	public void processarPecas(int numeroMaquina) {
		int quantidadeDeProcessamentos;
		Object auxiliar;
		
		switch (numeroMaquina) {
			
			case 1:
				 
				if(!verificarPecasParaSeremProcessadas(1)) {
					 throw new IllegalArgumentException("A máquina não possui peças");
				 }
				 
				 quantidadeDeProcessamentos = maquinaUm.pegaTamanho();

				 
				 for(int i = 0; i  < quantidadeDeProcessamentos; i++) {
					 auxiliar = maquinaUm.poll();
					 maquinaDois.adicionar(auxiliar);
				 }
				 // statusMaquinas();
				break;
			case 2:
				
				if(!verificarPecasParaSeremProcessadas(2)) {
					 throw new IllegalArgumentException("A máquina não possui peças");
				 }
				
				quantidadeDeProcessamentos = maquinaDois.pegaTamanho();
				
				for(int i = 0; i  < quantidadeDeProcessamentos; i++) {
					 auxiliar = maquinaDois.poll();
					 maquinaTres.adicionar(auxiliar);
				 }
				// statusMaquinas();
				break;
			case 3:
				if(!verificarPecasParaSeremProcessadas(3)) {
					 throw new IllegalArgumentException("A máquina não possui peças");
				 }
				
				quantidadeDeProcessamentos = maquinaTres.pegaTamanho();
				
				for(int i = 0; i  < quantidadeDeProcessamentos; i++) {
					 auxiliar = maquinaTres.poll();
					 this.pecasFinalizadas++;
				 }
				// statusMaquinas();
				break;
			default:
				throw new IllegalArgumentException("Máquina não existe");
		}
	}
}
