package app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.dto.Entrada;
import app.entity.Calculo;

@Service
public class CalculoService {

	public Calculo calcular(Entrada entrada) {

		Calculo calculo = new Calculo();
		calculo.setLista(entrada.getLista());
		calculo.setSoma(this.soma(entrada.getLista()));
		calculo.setMedia(this.media(entrada.getLista()));
		calculo.setMediana(this.mediana(entrada.getLista()));

		return calculo;

	}


	public int soma(List<Integer> lista) {
		int soma = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) == null)
				throw new RuntimeException("dslçfjakd");
			else
				soma += lista.get(i);
		}
		return soma;
	}


	public double media(List<Integer> lista) {
		return this.soma(lista) / lista.size();
	}


	public double mediana(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
		
		Collections.sort(lista);

	    if (lista.size() % 2 == 1) { //ÍMPAR
	        return lista.get(lista.size() / 2);
	    } else {
	        int meio1 = lista.get(lista.size() / 2 - 1);
	        int meio2 = lista.get(lista.size() / 2);
	        return (meio1 + meio2) / 2;
	    }
	}
	
	public double mediaPonderada(List<Integer> lista, List<Integer> pesoLista) {
		double mediaPonderada = 0;
		
		if (lista == null || lista.isEmpty() || pesoLista == null || pesoLista.isEmpty()) {
			throw new IllegalArgumentException("Nenhuma das listas podem ser nula ou vazia");
		}
		
		if(!(lista.size() == pesoLista.size())) {
			throw new IllegalArgumentException("Não há pesos o bastante para a lista de números");
		}
		
		double somaProdutos = 0;
		double somaPesos = 0;
		
		for(int i = 0; i < lista.size(); i++) {
			somaProdutos += lista.get(i) * pesoLista.get(i);
			somaPesos += pesoLista.get(i);
		}
		
		mediaPonderada = somaProdutos / somaPesos;
		
		return mediaPonderada;
	}
	
	public List<Integer> moda(List<Integer> lista){
		if(lista == null || lista.isEmpty()) {
			throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
		}
		
		Map<Integer, Integer> frequencias = new HashMap<>();
		
		for (Integer numero : lista) {
			frequencias.put(numero, frequencias.getOrDefault(numero, 0) +1 );
		}
		
		int maxFrequencias = Collections.max(frequencias.values());
		
		List<Integer> modas = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry : frequencias.entrySet()) {
	        if (entry.getValue() == maxFrequencias) {
	            modas.add(entry.getKey());
	        }
		}
		
	    if (modas.size() == lista.size()) {
	        throw new IllegalArgumentException("Não há moda para lista fornecida");
	    }

		
		return modas;
	}
	

}
