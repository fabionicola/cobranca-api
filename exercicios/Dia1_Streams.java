import java.util.*;
import java.util.stream.*;

public class Dia1_Streams {
    public static void main(String[] args) {
        List<Integer> valores = Arrays.asList(10, 20, 30, 40, 5, 7, 20);

        // 1) Filtrar > 10, remover deuplicados, ordenar e coletar

        List<Integer> processados = valores.stream()
            .filter(v -> v > 10)
            .distinct()
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Processados: " + processados);

        // 2) Somar Valores processados

        int soma = processados.stream()
            .mapToInt(v -> v)
            .sum();

        System.out.println("Soma: " + soma);

        // 3) Pegar o maior valor (Optional)
        OptionalInt max = valores.stream()
            .mapToInt(v -> v)
            .max();
        
        System.out.println("Max: " + (max.isPresent() ? max.getAsInt(): "sem valores"));

    }
}
