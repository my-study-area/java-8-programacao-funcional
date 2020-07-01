# java-8-programacao-funcional
Estudo de Java 8 no youtube da lista [Java 8: Programação Funcional – Lambda, Streams, Optional, etc.](https://www.youtube.com/playlist?list=PLuYctAHjg89ZkhgOQo0zcTtmHY5nuRYud)

## Contéudo

## 1. Entenda FACILMENTE funções LAMBDA do JAVA 8, a principal novidade!

## 2. PARE de usar ‘for’, use STREAMS e simplifique seu código! - Parte 1
- Java 4
    ```java
    // Java 4
    for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
        Integer integer = (Integer) iterator.next();
        System.out.println(integer);
    }
    ```

- Java 5
    ```java
    // Java 5
    for (Integer integer : lista) {
        System.out.println(integer);
    }
    ```
- Java 8
    ```java
        // Java 8
        lista.stream().forEach(l -> System.out.println(l));
    ```
- Stream
    - Operacções Intermediárias
        -  skip
        ```java
            lista.stream()
                .skip(2)
                .forEach(elemento -> System.out.print(elemento));
        ```
        - limit
        ```java
            lista.stream()
            .limit(2)
            .forEach(elemento -> System.out.println(elemento));
        ```
        - distinc
        ```java
            lista.stream()
            .distinct()
            .forEach(elemento -> System.out.println(elemento));
        ```
        - filter
        ```java
            lista.stream()
            .filter( element -> element % 2 == 0)
            .forEach(elemento -> System.out.println(elemento));
        ```
        - map
        ```java
            lista.stream()
            .map( elemento -> elemento + ",")
            .forEach(elemento -> System.out.println(elemento));
        ```
