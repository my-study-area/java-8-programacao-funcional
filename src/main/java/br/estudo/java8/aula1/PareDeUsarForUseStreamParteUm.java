package br.estudo.java8.aula1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class PareDeUsarForUseStreamParteUm {
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

		// Java 4
//		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
//			Integer integer = (Integer) iterator.next();
//			System.out.println(integer);
//		}
		
		// Java 5
//		System.out.println("Java 5");
//		for (Integer integer : lista) {
//			System.out.println(integer);
//		}
		
		// Java 8
		System.out.println("java 8");
//		lista.stream().forEach(l -> System.out.println(l));

		//skip
//		System.out.println("skip");
//		lista.stream()
//			.skip(2)
//			.forEach(l -> System.out.print(l)); 
		
		//limit
		System.out.println("limit");
		lista.stream()
		.limit(2)
		.forEach(elemento -> System.out.println(elemento));
		
		//distinct
		System.out.println("distinct");
		lista.stream()
		.distinct()
		.forEach(elemento -> System.out.println(elemento));
		
		//filter
		System.out.println("filter");
		lista.stream()
		.filter( element -> element % 2 == 0)
		.forEach(elemento -> System.out.println(elemento));
		
		//map
		System.out.println("map");
		lista.stream()
		.map( elemento -> elemento + ",")
		.forEach(elemento -> System.out.println(elemento));
		
	}
}
