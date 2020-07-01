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
    - Operacções finais
		- Count
            ```java
            long count = lista.stream()
                .filter(e -> e % 2 == 0)
                .count();
            System.out.println(count);
            
            ```
		- Min Max
            ```java
    		Optional<Integer> min = lista.stream()
                .map(e -> e + -1 )
                .min(Comparator.naturalOrder());
                System.out.println(min.get());		
                
			Optional<Integer> max = lista.stream()
                .map(e -> e + -1 )
                .max(Comparator.naturalOrder());
			System.out.println(max.get());		
            ```
			
		- Collect toList
            ```java
            List<Integer> novaLista = lista.stream()
                .map(e -> 2 + 3)
                .collect(Collectors.toList());
            System.out.println(novaLista);
            ```
		
		- Collect groupingBy
            ```java
            Map<Boolean, List<Integer>> mapa = lista.stream()
                    .map(e -> e * 3)
                    .collect(Collectors.groupingBy(e -> e % 2 == 0));
            System.out.println(mapa);
            
            Map<Integer, List<Integer>> mapa2 = lista.stream()
                    .collect(Collectors.groupingBy(e -> e % 2));
            System.out.println(mapa2);
            ```
		
		- Collect Joining
            ```java
            lista.stream()
            .map(e -> String.valueOf(e))
            .collect(Collectors.joining(";"));
            ```
    - Outras formas de criar streams
        * De um array utilizando Arrays.stream(Object[]);
        * De métodos estáticos em classes de stream, como Stream.of(Object[]), IntStream.range(int, int);
        * As linhas de um arquivo podem ser obtidas com BufferedReader.lines();
        * Streams de arquivos podem ser obtidos através de métodos na classe Files;
        * Streams de números aleatórios podem ser obtidos em Random.ints().     
        Fonte: [java 8 streams pare de usar-for e simplifique seu codigo](https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo/)

