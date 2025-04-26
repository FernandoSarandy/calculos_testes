package app.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculoService;

@SpringBootTest
public class CalculoServiceTest {
	
	@Autowired
	CalculoService calculoService;
	
	@Test
	@DisplayName("Cena 01 - Testando o método somar com valores válidos")
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(5);
		lista.add(2);
		
		int resultadoEsperado = 10;
		int resultadoObtido = this.calculoService.soma(lista);
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	

	@Test
	@DisplayName("Cena 02 - Testando o método somar com valores inválidos")
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(null);
		lista.add(2);
				
		assertThrows(Exception.class,() -> {
			this.calculoService.soma(lista);
		});
		
		
	}
	
	
	
	
	@Test
	@DisplayName("Cena 03 - Testar mediana com número par de elementos")
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 04 - Testar mediana com número ímpar de elementos")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	
	@Test
	@DisplayName("Cena 05 - Testar mediana com número ímpar de elementos")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(39);
		lista.add(339);
		lista.add(4);
		
		assertEquals(8, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 06 - Teste de media ponderada, valor experado.")
	void cenario06() {
		List<Integer> lista = new ArrayList<>();
		lista.add(7);
		lista.add(8);
		lista.add(6);
		
		List<Integer> listaPeso = new ArrayList<>();
		listaPeso.add(2);
		listaPeso.add(3);
		listaPeso.add(5);
		
		double resultado = this.calculoService.mediaPonderada(lista, listaPeso);
		assertEquals(6.8, resultado);
	}
	
	@Test
	@DisplayName("Cena 06 - Teste de media ponderada, lista vazias ou nula")
	void cenario07() {
		List<Integer> lista = new ArrayList<>();
		List<Integer> listaPeso = new ArrayList<>();
		listaPeso.add(2);
		listaPeso.add(3);
		listaPeso.add(5);
		
		assertThrows(Exception.class,() -> {
			this.calculoService.mediaPonderada(lista, listaPeso);
		});
	}
	
	@Test
	@DisplayName("Cena 06 - Teste de media ponderada, sem valores o suficiente.")
	void cenario08() {
		List<Integer> lista = new ArrayList<>();
		lista.add(7);
		lista.add(8);
		lista.add(6);
		
		List<Integer> listaPeso = new ArrayList<>();
		listaPeso.add(2);
		listaPeso.add(3);
		
		assertThrows(Exception.class,() -> {
			this.calculoService.mediaPonderada(lista, listaPeso);
		});
	}
	
	@Test
	@DisplayName("Cena 09 - Testar mediana com lista vazia")
	void cenario09() {
		List<Integer> lista = new ArrayList<>();

		assertThrows(Exception.class,() -> {
			this.calculoService.mediana(lista);
		});
	}
	
	@Test
	@DisplayName("Cena 10 - Testar media")
	void cenario10() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		
		double resultado = this.calculoService.media(lista);
		assertEquals(3, resultado);
		
	}
	
	@Test
	@DisplayName("Cena 11 - Teste de unimodal")
	void cenario11() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(2);
		lista.add(1);
		lista.add(6);
		
		List<Integer> resultado = calculoService.moda(lista);
		assertEquals(Arrays.asList(2), resultado);
	}
	
	@Test
	@DisplayName("Cena 12 - Teste de bimodal")
	void cenario12() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(2);
		lista.add(3);
		lista.add(6);
		
		List<Integer> resultado = calculoService.moda(lista);
		assertEquals(Arrays.asList(2, 3), resultado);
	}
	
	@Test
	@DisplayName("Cena 13 - Teste de lista sem moda")
	void cenario13() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(6);
		
		assertThrows(Exception.class,() -> {
			this.calculoService.moda(lista);
		});
	}
	
	@Test
	@DisplayName("Cena 14 - teste lista vazia")
	void cenario14() {
		List<Integer> lista = new ArrayList<>();
		
		assertThrows(Exception.class,() -> {
			this.calculoService.moda(lista);
		});
	}
	
}
