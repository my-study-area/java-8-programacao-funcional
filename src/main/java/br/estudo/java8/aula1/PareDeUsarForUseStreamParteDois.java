package br.estudo.java8.aula1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PareDeUsarForUseStreamParteDois {
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
		
		//Count
		long count = lista.stream()
			.filter(e -> e % 2 == 0)
			.count();
		System.out.println(count);
		
		//Min Max
		Optional<Integer> min = lista.stream()
			.map(e -> e + -1 )
			.min(Comparator.naturalOrder());
			System.out.println(min.get());		
			
			Optional<Integer> max = lista.stream()
					.map(e -> e + -1 )
					.max(Comparator.naturalOrder());
			System.out.println(max.get());		
			
		//Collect toList
		List<Integer> novaLista = lista.stream()
			.map(e -> 2 + 3)
			.collect(Collectors.toList());
		System.out.println(novaLista);
		
		Map<Boolean, List<Integer>> mapa = lista.stream()
			.map(e -> e * 3)
			.collect(Collectors.groupingBy(e -> e % 2 == 0));
		System.out.println(mapa);
		
		Map<Integer, List<Integer>> mapa2 = lista.stream()
			.collect(Collectors.groupingBy(e -> e % 2));
		System.out.println(mapa2);
		
		//Collect groupingBy
		lista.stream()
		.map(e -> String.valueOf(e))
			.collect(Collectors.joining(";"));
		
		//Collect Joining
		
		//Loops explícitos vs Loops implícitos
		
		//Outras formas de criar Streams
		
		
	}
}
