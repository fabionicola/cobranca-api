import java.time.LocalDate;

public class Dia1_Exceptions {

    //Simula um "Título" de cobrança (bem simples por enquanto)

    static class Titulo {
        String clienteNome;
        double valor;
        LocalDate vencimento;
        boolean pago;
        
        Titulo(String clienteNome, double valor, LocalDate vencimento)
        {
            this.clienteNome = clienteNome;
            this.valor = valor;
            this.vencimento = vencimento;
            this.pago = false;
        }

        @Override
        public String toString(){
            return "Titulo{cliente='" + clienteNome + "', valor= " + valor + ", vencimento= " + vencimento + ", pago=" + pago + "}";
        }

    }


    //Validação na mão: if + throw

    static Titulo criarTitulo(String clienteNome, double valor, LocalDate vencimento) {

        // 1) Nome do cliente não pode ser nulo ou vazio
        if (clienteNome == null || clienteNome.trim().isEmpty()) {
            throw new IllegalArgumentException("Cliente inválido: nome vazio");
        }

        // 2) Valor precisa ser maior que zero

        if (valor < 0) {
            throw new IllegalArgumentException("Valor Inválido: dever ser > 0");
        }
        

        // 3) Vencimento não poder ser nulo
        if (vencimento == null) {
            throw new IllegalArgumentException("Vencimento inválido: nulo");
        }

        // 4) regra simples: vencimento não pode ser muito no passado
        //(aqui a regra é: não pode ser antes de hj - 30 dias)
        LocalDate limite = LocalDate.now().minusDays(30);
        if (vencimento.isBefore(limite)) {
            throw new IllegalArgumentException("Vencimento inválido: muito antigo (antes de " + limite + ")");
        }

        // Se passou por tudo "cria" o título
        return new Titulo(clienteNome.trim(), valor, vencimento);
    }

    public static void main(String[] args) {
        
        //vamos testar os 4 cenarios: 3 invalidos + 1 valido
        testar(" ", 100, LocalDate.now().plusDays(10)); //inválido: cliente vazio
        testar("Maria", -50, LocalDate.now().plusDays(10)); //inválido: valor
        testar("João", 200, LocalDate.now().plusDays(10)); //inválido: vencimento muito antigo
        testar(" ", 100, LocalDate.now().plusDays(100)); //inválido: cliente vazio
        testar("Fabio", 350, LocalDate.now().plusDays(5)); //válido
    }

    static void testar(String cliente, double valor, LocalDate vencimento){
        try {
            Titulo t = criarTitulo(cliente , valor, vencimento);
            System.err.println("✅ Criado com Sucesso: " + t);
        } catch (Exception e) {
            System.err.println("❌ Erro ao criar titulo: " + e.getMessage());
        }
    }

}
