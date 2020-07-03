package br.estudo.java8.aula1;

import java.rmi.server.Operation;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class PareDeUsarNullUseOptional {
    public static void main(String[] args) {
        System.out.println("=== Antes do java 8 ===");
        String string = "1";
        Integer numero = converteEmNumeroAntesDoJavaOito(string);
        System.out.println(numero);
        
        string = "texto";
        System.out.println(converteEmNumeroAntesDoJavaOito(string));
        
        System.out.println("");
        System.out.println("=== No java 8 ====");
        string = "1";
        Optional<Integer> optional = converteEmNumero(string); 
        System.out.println(optional);
        
        string = "texto";
        optional = converteEmNumero(string);
        System.out.println(optional);
        
        System.out.println("");
        System.out.println("=== Criando Optional ===");
        System.out.println(Optional.of("2"));
//        System.out.println(Optional.of(null)); //dispara NullPointerExceptional
        System.out.println(Optional.ofNullable(null)); //retorna Optional.empty
        System.out.println(Optional.empty()); //retorna Optional.empty
        
        System.out.println("");
        System.out.println("=== Usando Optional ===");
        Optional<Integer> optionalNumber = converteEmNumero("7");
        System.out.println(optionalNumber.isPresent());
        
        Optional<Integer> optionalString = converteEmNumero("teste");
        System.out.println(optionalString.isPresent());
        
        System.out.println("");
        System.out.println("=== Usando Optional: ifPresent ===");
        optionalNumber.ifPresent(e -> System.out.println(e)); //7
        optionalString.ifPresent(e -> System.out.println(e)); // obs: não imprime nada
        
        System.out.println("");
        System.out.println("=== Usando Optional: get===");
        System.out.println(optionalNumber.get()); // 7
        //System.out.println(optionalString.get()); // NoSuchElementException: No value present
        
        System.out.println("");
        System.out.println("=== Usando Optional: orElse===");
        System.out.println(converteEmNumero("7").orElse(10)); // 7
        System.out.println(converteEmNumero("texto qualquer").orElse(2)); // 2
        
        System.out.println("");
        System.out.println("=== Usando Optional: orElseGet===");
        // indicado para realizar operações pesadas ao passar uma função como parâmetro
        System.out.println(converteEmNumero("7").orElseGet(() -> 10)); // 7
        System.out.println(converteEmNumero("texto qualquer").orElseGet(() -> 10)); // 10
        
        System.out.println("");
        System.out.println("=== Usando Optional: orThrows===");
        // indicado para realizar operações pesadas ao passar uma função como parâmetro
        System.out.println(converteEmNumero("7").orElseThrow(() -> new NullPointerException("Valor vazio"))); // 7
//        System.out.println(converteEmNumero("texto qualquer").orElseThrow(() -> new NullPointerException("Valor vazio"))); // dispara NullPointerException: Valor vazio
        
        System.out.println("");
        System.out.println("=== Usando Optional: getFirst===");
        Stream.of(1,2,3)
        .findFirst()
        .ifPresent(System.out::println);
        
        System.out.println("");
        System.out.println("=== Optional Primitivos===");
        System.out.println(converteEmNumeroInt("7"));
        System.out.println(converteEmNumeroInt("qualquer texto"));
        
        
    }

    
    public static Integer converteEmNumeroAntesDoJavaOito(String numeroStr) {
        try {
            return Integer.valueOf(numeroStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Optional<Integer> converteEmNumero(String numeroStr) {
        try {
          Integer integer = Integer.valueOf(numeroStr);
          return Optional.of(integer);
        } catch (Exception e) {
          return Optional.empty();
        }
    }
    
    public static OptionalInt converteEmNumeroInt(String numeroStr) {
        try {
            Integer integer = Integer.valueOf(numeroStr);
            return OptionalInt.of(integer);
        } catch (Exception e) {
            return OptionalInt.empty();
        }
    }
}
