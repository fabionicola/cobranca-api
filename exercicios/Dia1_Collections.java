import java.util.*;

public class Dia1_Collections {
    public static void main(String[] args) {
        List<String> entrada = Arrays.asList("Fabio", "Maria", "João", "Ana", "Maria", "Ana");

        // 1) Remover Duplicados
        Set<String> unicos = new HashSet<>(entrada);

        // 2) Ordenar
        List<String> ordenados = new ArrayList<>(unicos);
        Collections.sort(ordenados);

        //imprimir
        for (String nome : ordenados) {
            System.out.println(nome);
        }


    }
}