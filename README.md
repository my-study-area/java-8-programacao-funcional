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

## 3. Pare de retornar NULL, use OPTIONAL do JAVA 8!
- Antes do Java 8
    ```java
    public static Integer converteEmNumeroAntesDoJavaOito(String numeroStr) {
        try {
            return Integer.valueOf(numeroStr);
        } catch (Exception e) {
            return null;
        }
    }

    String string = "1";
    Integer numero = converteEmNumeroAntesDoJavaOito(string);
    System.out.println(numero); //1
    
    string = "texto";
    System.out.println(converteEmNumeroAntesDoJavaOito(string)); //null
    ```
- Criando Optional
    ```java
    public static Optional<Integer> converteEmNumero(String numeroStr) {
        try {
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.of(integer);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    string = "1";
    Optional<Integer> optional = converteEmNumero(string); 
    System.out.println(optional); //Optional[1]
    
    string = "texto";
    optional = converteEmNumero(string);
    System.out.println(optional); //Optional.empty
    ```
    - of
    ```java
        System.out.println(Optional.of("2"));
        System.out.println(Optional.of(null)); //dispara NullPointerExceptional
    ```
    - ofNullable
    ```java
        System.out.println(Optional.ofNullable(null)); // Optional.empty
        System.out.println(Optional.empty()); //Optional.empty
    ```
- Usando Optional

    - isPresent
    ```java
    Optional<Integer> optionalNumber = converteEmNumero("7");
    System.out.println(optionalNumber.isPresent()); //true

    Optional<Integer> optionalString = converteEmNumero("teste");
    System.out.println(optionalString.isPresent()); //false
    ```

    - get
    ```java
    System.out.println(optionalNumber.get()); // 7
    System.out.println(optionalString.get()); // dispara NoSuchElementException: No value present
    ```

    - ifPresent
    ```java
    optionalNumber.ifPresent(e -> System.out.println(e)); //7
    optionalString.ifPresent(e -> System.out.println(e)); // obs: não imprime nada
    ```

    - orElse
    ```java
    System.out.println(converteEmNumero("7").orElse(10)); // 7
    System.out.println(converteEmNumero("texto qualquer").orElse(2)); // 2
    ```

    - orElseGet
    ```java
    // indicado para realizar operações pesadas ao passar uma função como parâmetro
    System.out.println(converteEmNumero("7").orElseGet(() -> 10)); // 7
    System.out.println(converteEmNumero("texto qualquer").orElseGet(() -> 10)); // 10
    ```

    - orElseThrow
    ```java
    System.out.println(converteEmNumero("7")
        .orElseThrow(() -> new NullPointerException("Valor vazio"))); // 7
    System.out.println(converteEmNumero("texto qualquer")
        .orElseThrow(() -> new NullPointerException("Valor vazio"))); // dispara NullPointerException: Valor vazio
    ```

    - findFirst
    ```java
    Stream.of(1,2,3)
        .findFirst()
        .ifPresent(System.out::println);
    ```
- Tipo Primitivo

Exemplo com int (é possível com os outros primitivos)
```java
public static OptionalInt converteEmNumeroInt(String numeroStr) {
    try {
        Integer integer = Integer.valueOf(numeroStr);
        return OptionalInt.of(integer);
    } catch (Exception e) {
        return OptionalInt.empty();
    }
}
```
## 4. Aprenda a fazer REDUCE em STREAMS do JAVA 8!
- Função de acumulação
    - Soma
    ```java
    List<Integer> list = Arrays.asList(1,2,3,4,5,6);
    
    //reduce soma
    Optional<Integer> reduce = list.stream()
    .reduce((n1, n2) -> n1 + n2);
    
    reduce.ifPresent(System.out::println);
    ```

    - Multiplicação
    ```java
    //reduce multiplicação
    Optional<Integer> multiplicacao = list.stream()
            .reduce((n1, n2) -> n1 * n2);
    multiplicacao.ifPresent(System.out::println); //720
    ```

    - Concatenação
    ```java
    //reduce - concatenaçao
    String texto ="Um texto qualquer";
    String[] split = texto.split(" ");
    List<String> listString = Arrays.asList(split);
    Optional<String> cancatenacao = listString
        .stream()
        .reduce((c1, c2) -> c1.concat(c2));
    cancatenacao.ifPresent(System.out::println); //Umtextoqualquer
    ```

    > Obs: As operações de soma, multiplicação e concatenação são associativas, ou seja, 1 + 2 + 3 + 4  = (1+2) + (3+4)

    - Subtração
    ```java
    //reduce - subtração : NÃO FAÇA
    Optional<Integer> subtracao = list.stream()
    .reduce((n1, n2) -> n1 - n2);
    subtracao.ifPresent(System.out::println); //-19
    
    
    Optional<Integer> subtracao2 = list.stream()
            .parallel()
            .reduce((n1, n2) -> n1 - n2);
    subtracao2.ifPresent(System.out::println); //-3
    ```

    > Obs: não usar subtração com reduce, pois a subtração não é uma função associativa
