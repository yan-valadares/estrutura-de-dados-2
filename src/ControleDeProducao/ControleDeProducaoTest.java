package ControleDeProducao;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleDeProducaoTest {

	ControleDeProducao controleDeProducao;
	
	@BeforeEach
    void init() {
		controleDeProducao = new ControleDeProducao();
    }
	
	@Test
	public void inserirPecasPrimeiraMaquinaTest() {
		
		controleDeProducao.adicionarPecas(3);
		
		int[] arrayEsperadoQuantidadePecasEmCadaMaquina = { 3, 0, 0};
		assertArrayEquals(arrayEsperadoQuantidadePecasEmCadaMaquina, controleDeProducao.retornarTotalDePecasEmCadaMaquina());
		Object[] arrayEsperadoIDPecas = { 1, 2, 3};
		assertArrayEquals(arrayEsperadoIDPecas, controleDeProducao.retornaIdPecas(1));
	}
	
	@Test
	public void ProcessarPecasPrimeiraMaquinaSemElementosTest() {
	
		assertThrows(IllegalArgumentException.class, () -> controleDeProducao.processarPecas(1));
	}
	
	@Test
	public void ProcessarPecasPrimeiraMaquinaComElementosTest() {
		
		controleDeProducao.adicionarPecas(3);
		controleDeProducao.processarPecas(1);
		
		int[] arrayEsperado = { 0, 3, 0};
		assertArrayEquals(arrayEsperado, controleDeProducao.retornarTotalDePecasEmCadaMaquina());
	}
	
	@Test
	public void ProcessarPecasPrimeiraMaquinaComElementosEAdicionarMaisPecasTest() {
		
		controleDeProducao.adicionarPecas(3);
		controleDeProducao.processarPecas(1);
		controleDeProducao.adicionarPecas(5);
		
		int[] arrayEsperado = { 5, 3, 0};
		assertArrayEquals(arrayEsperado, controleDeProducao.retornarTotalDePecasEmCadaMaquina());
		Object[] arrayEsperadoIDPecas = { 4, 5, 6, 7, 8};
		assertArrayEquals(arrayEsperadoIDPecas, controleDeProducao.retornaIdPecas(1));
	}

	@Test
	public void ProcessarPecasSegundaMaquinaSemElementosTest() {
	
		assertThrows(IllegalArgumentException.class, () -> controleDeProducao.processarPecas(2));
	}
	
	@Test
	public void ProcessarPecasSegundaMaquinaComElementosTest() {
		
		controleDeProducao.adicionarPecas(20);
		controleDeProducao.processarPecas(1);
		controleDeProducao.processarPecas(2);
		
		int[] arrayEsperado = { 0, 0, 20};
		assertArrayEquals(arrayEsperado, controleDeProducao.retornarTotalDePecasEmCadaMaquina());
	}
	
	@Test
	public void ProcessarPecasSegundaMaquinaComElementosEAdicionarMaisElementosTest() {
		
		controleDeProducao.adicionarPecas(20);
		controleDeProducao.processarPecas(1);
		controleDeProducao.processarPecas(2);
		controleDeProducao.adicionarPecas(20);
		
		int[] arrayEsperado = { 20, 0, 20};
		assertArrayEquals(arrayEsperado, controleDeProducao.retornarTotalDePecasEmCadaMaquina());
	}
	
	@Test
	public void ProcessarPecasTerceiraMaquinaSemElementosTest() {
	
		assertThrows(IllegalArgumentException.class, () -> controleDeProducao.processarPecas(3));
	}
	
	@Test
	public void ProcessarPecasTerceiraMaquinaComElementosTest() {
		
		controleDeProducao.adicionarPecas(20);
		controleDeProducao.processarPecas(1);
		controleDeProducao.processarPecas(2);
		controleDeProducao.processarPecas(3);
		
		int[] arrayEsperado = { 0, 0, 0};
		assertArrayEquals(arrayEsperado, controleDeProducao.retornarTotalDePecasEmCadaMaquina());
		assertEquals(20, controleDeProducao.getNumeroPecasFinalizadas());
	}
	
	@Test
	public void ProcessarPecasTerceiraMaquinaComElementosEAdicionarMaisElementosTest() {
		
		controleDeProducao.adicionarPecas(20);
		controleDeProducao.processarPecas(1);
		controleDeProducao.processarPecas(2);
		controleDeProducao.processarPecas(3);
		controleDeProducao.adicionarPecas(20);
		controleDeProducao.processarPecas(1);
		controleDeProducao.processarPecas(2);
		
		int[] arrayEsperado = { 0, 0, 20};
		assertArrayEquals(arrayEsperado, controleDeProducao.retornarTotalDePecasEmCadaMaquina());
		assertEquals(20, controleDeProducao.getNumeroPecasFinalizadas());
		assertEquals(40, controleDeProducao.getNumeroPecasProduzidas());
	}
	
	@Test
	public void ProcessarPecasMaquinaInexistenteTest() {

		assertThrows(IllegalArgumentException.class, () -> controleDeProducao.processarPecas(5));
		
	}
	
	@Test
	public void ProcessarProducaoEmMassaTest() {

		controleDeProducao.producaoCompleta(20);
		controleDeProducao.producaoCompleta(30);
		controleDeProducao.adicionarPecas(20);
		
		int[] arrayEsperado = { 20, 0, 0};
		assertArrayEquals(arrayEsperado, controleDeProducao.retornarTotalDePecasEmCadaMaquina());
		assertEquals(50, controleDeProducao.getNumeroPecasFinalizadas());
		assertEquals(70, controleDeProducao.getNumeroPecasProduzidas());
		
	}
	
}
