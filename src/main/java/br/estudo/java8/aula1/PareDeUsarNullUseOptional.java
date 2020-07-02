package br.estudo.java8.aula1;

import java.util.Optional;

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
}
