package OrdemAlfabetica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdemAlfabeticaTest {

	OrdemAlfabetica pilhaOrdenada;
	
	@BeforeEach
	void init() {
		pilhaOrdenada = new OrdemAlfabetica();
	}

	@Test
	void adicionarUmaPessoaSemElementoTest() {

		pilhaOrdenada.push("Yan");
		
		assertEquals(1, pilhaOrdenada.getTamanho());
	}

	@Test
	void removerUmaPessoaSemElementoTest() {

		assertThrows(IllegalArgumentException.class, () -> pilhaOrdenada.pop());
	}

	@Test
	void adicionarUmaPessoaComElementoTest() {

		pilhaOrdenada.push("Yan");
		pilhaOrdenada.push("Ana");

		assertEquals(2, pilhaOrdenada.getTamanho());
		assertEquals("Yan", pilhaOrdenada.popTest());
		assertEquals("Ana", pilhaOrdenada.popTest());
	}

	@Test
	void removerUmaPessoaComElementoTest() {

		pilhaOrdenada.push("Yan");
		pilhaOrdenada.push("Ana");
		pilhaOrdenada.pop();

		assertEquals(1, pilhaOrdenada.getTamanho());
		assertEquals("Ana", pilhaOrdenada.popTest());
	}

	@Test
	void removerPessoaMuitosElementosTest() {

		pilhaOrdenada.push("Yan");
		pilhaOrdenada.push("Ana");
		pilhaOrdenada.push("Leticia");
		pilhaOrdenada.push("Bruno");
		pilhaOrdenada.pop();

		assertEquals(3, pilhaOrdenada.getTamanho());
		assertEquals("Leticia", pilhaOrdenada.top());
	}

	@Test
	void compararTodosOsElementosTest() {

		pilhaOrdenada.push("Yan");
		pilhaOrdenada.push("Ana");
		pilhaOrdenada.push("Leticia");
		pilhaOrdenada.push("Bruno");

		assertEquals(4, pilhaOrdenada.getTamanho());
		assertEquals("Yan", pilhaOrdenada.popTest());
		assertEquals("Leticia", pilhaOrdenada.popTest());
		assertEquals("Bruno", pilhaOrdenada.popTest());
		assertEquals("Ana", pilhaOrdenada.popTest());
	}

}
