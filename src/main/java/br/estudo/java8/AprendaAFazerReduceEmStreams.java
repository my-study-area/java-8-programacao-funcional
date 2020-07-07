package br.estudo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class AprendaAFazerReduceEmStreams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        
        //reduce soma
        Optional<Integer> soma = list.stream()
        .reduce((n1, n2) -> n1 + n2);
        soma.ifPresent(System.out::println); //21
        
        //reduce multiplicação
        Optional<Integer> multiplicacao = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        multiplicacao.ifPresent(System.out::println); //720
        
        //reduce - concatenaçao
        String texto ="Um texto qualquer";
        String[] split = texto.split(" ");
        List<String> listString = Arrays.asList(split);
        Optional<String> cancatenacao = listString.stream()
            .reduce((c1, c2) -> c1.concat(c2));
        cancatenacao.ifPresent(System.out::println); //Umtextoqualquer
        
        //reduce - subtração : NÃO FAÇA
        Optional<Integer> subtracao = list.stream()
        .reduce((n1, n2) -> n1 - n2);
        subtracao.ifPresent(System.out::println); //-19
        
        
        Optional<Integer> subtracao2 = list.stream()
                .parallel()
                .reduce((n1, n2) -> n1 - n2);
        subtracao2.ifPresent(System.out::println); //-3
        
        //IDENTIDADE
        //reduce soma
        Optional<Integer> soma2 = list.stream()
        .reduce((n1, n2) -> n1 + n2);
        soma2.ifPresent(System.out::println); //21
        
        //reduce multiplicação
        Integer multiplicacao2 = list.stream()
                .reduce(1,(n1, n2) -> n1 * n2);
        System.out.println(multiplicacao2); //720
        
        //reduce - concatenaçao
        String concatenacao2 = listString.stream()
            .reduce("",(c1, c2) -> c1.concat(c2));
        System.out.println(concatenacao2); //Umtextoqualquer
        
        // reduce - menor valor
        double menorValor = DoubleStream.of(1.5, 2.9, 6.7)
          .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(menorValor); // 1.5
        
        // reduce - soma
        Integer soma3 = list.stream()
          .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        
        System.out.println(soma3);    
        
        // reduce - map + combiner
        String reduce = list.stream()
            .reduce(
                "", 
                (n1, n2) -> n1.toString().concat(n2.toString()), 
                (n1, n2) -> n1.concat(n2)
              );
        System.out.println(reduce);
    }
}
