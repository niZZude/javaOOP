import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEcopoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando resíduos
        Residuo plastico = new Plastico();
        Residuo metal = new Metal();
        Residuo papel = new Papel();
        Residuo vidro = new Vidro();
        List<Residuo> todosResiduos = List.of(plastico, metal, papel, vidro);

        // Criando pontos de coleta
        List<String> tiposAceitos = List.of("Plástico", "Papel", "Metal", "Vidro");
        PontoDeColeta ponto1 = new PontoDeColeta("Ecoponto Centro", "Rua Avelino Vinicius, 123", tiposAceitos);
        PontoDeColeta ponto2 = new PontoDeColeta("Ecoponto Frei Serafim", "Rua José Barroso, 8971", tiposAceitos);
        PontoDeColeta ponto3 = new PontoDeColeta("Ecoponto Dom Severino", "Rua Leonor Coelho, 3421", tiposAceitos);
        PontoDeColeta ponto4 = new PontoDeColeta("Ecoponto Centenário", "Rua Ponte Alta, 542", tiposAceitos);

        List<PontoDeColeta> todosPontosDeColeta = List.of(ponto1, ponto2, ponto3, ponto4);

        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();
        Usuario usuarioAtual = new Usuario(nomeUsuario);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha um ponto de coleta:");
            for (int i = 0; i < todosPontosDeColeta.size(); i++) {
                System.out.println((i + 1) + " - " + todosPontosDeColeta.get(i).getNome());
            }
            System.out.print("Sua escolha: ");
            int escolhaPonto = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (escolhaPonto < 1 || escolhaPonto > todosPontosDeColeta.size()) {
                System.out.println("Escolha inválida. Tente novamente.");
                continue;
            }

            PontoDeColeta pontoSelecionado = todosPontosDeColeta.get(escolhaPonto - 1);

            List<Residuo> residuosSelecionados = new ArrayList<>();
            boolean escolherMais = true;


            while (escolherMais) {
                System.out.println("\nEscolha um resíduo para adicionar:");
                for (int i = 0; i < todosResiduos.size(); i++) {
                    System.out.println((i + 1) + " - " + todosResiduos.get(i).getNome());
                }
                System.out.print("Sua escolha: ");
                int escolhaResiduo = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                if (escolhaResiduo < 1 || escolhaResiduo > todosResiduos.size()) {
                    System.out.println("Escolha inválida. Tente novamente.");
                    continue;
                }

                Residuo residuoSelecionado = todosResiduos.get(escolhaResiduo - 1);
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
