import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEcopoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando resíduos
        residuo plastico = new residuo("Plástico", "Reciclável");
        residuo metal = new residuo("Metal", "Reciclável");
        residuo papel = new residuo("Papel", "Reciclável");
        residuo vidro = new residuo("Vidro", "Não Reciclável");

        List<residuo> todosResiduos = List.of(plastico, metal, papel, vidro);

        // Criando pontos de coleta
        List<String> tiposAceitos = List.of("Plástico", "Papel");
        pontoDeColeta ponto1 = new pontoDeColeta("Ecoponto Centro", "Av. Principal, 123", tiposAceitos);
        pontoDeColeta ponto2 = new pontoDeColeta("Ecoponto Frei Serafim", "Av. Frei Serafim, 873", tiposAceitos);

        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();
        usuario usuarioAtual = new usuario(nomeUsuario);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha um ponto de coleta:");
            System.out.println("1 - " + ponto1.getNome());
            System.out.println("2 - " + ponto2.getNome());
            System.out.print("Sua escolha: ");
            int escolhaPonto = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            pontoDeColeta pontoSelecionado = (escolhaPonto == 1) ? ponto1 : ponto2;

            List<residuo> residuosSelecionados = new ArrayList<>();
            boolean escolherMais = true;

            while (escolherMais) {
                System.out.println("\nEscolha um resíduo para adicionar:");
                System.out.println("1 - Plástico");
                System.out.println("2 - Metal");
                System.out.println("3 - Papel");
                System.out.println("4 - Vidro");
                System.out.print("Sua escolha: ");
                int escolhaResiduo = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                residuo residuoSelecionado = todosResiduos.get(escolhaResiduo - 1);
                residuosSelecionados.add(residuoSelecionado);

                System.out.print("Deseja adicionar mais resíduos? (s/n): ");
                String resposta = scanner.nextLine();
                escolherMais = resposta.equalsIgnoreCase("s");
            }

            // Descartando todos os resíduos escolhidos
            usuarioAtual.descartarResiduos(pontoSelecionado, residuosSelecionados);

            System.out.print("\nDeseja continuar? (s/n): ");
            String resposta = scanner.nextLine();
            continuar = resposta.equalsIgnoreCase("s");
        }

        System.out.println("Obrigado por usar o Sistema Ecopoint!");
        scanner.close();
    }
}
