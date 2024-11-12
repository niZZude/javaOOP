import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEcopoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        // Criar os resíduos e pontos de coleta
        List<Residuo> todosResiduos = new ArrayList<>();
        todosResiduos.add(new Residuo("Papel", 1));
        todosResiduos.add(new Residuo("Papelão", 5));
        todosResiduos.add(new Residuo("Vidro", 10));
        todosResiduos.add(new Residuo("Pet", 15));
        todosResiduos.add(new Residuo("Plástico", 15));
        todosResiduos.add(new Residuo("Metal", 15));
        todosResiduos.add(new Residuo("Eletrônico", 15));

        List<PontoDeColeta> pontosDeColeta = new ArrayList<>();
        pontosDeColeta.add(new PontoDeColeta("ASCAMARES", "Rua Henrique Dias - Centro", List.of("papel", "papelão", "embalagens Pet", "plástico")));
        pontosDeColeta.add(new PontoDeColeta("EXTRA SUPERMERCADO", "Av. Presidente Kennedy", List.of("papelão", "plástico", "alumínio", "aço", "vidro")));
        pontosDeColeta.add(new PontoDeColeta("PÃO DE AÇÚCAR", "Av. Dom Severino com Homero Castelo Branco – Jóquei Clube", List.of("celulares", "papelão", "plástico", "alumínio", "aço", "vidro")));
        pontosDeColeta.add(new PontoDeColeta("PROJETO LIXO CRIATIVO", "Av. Roraima, 2100 - (Próximo ao Diário do Povo) - Zona Norte – Aeroporto", List.of("papel", "papelão", "alumínio", "plástico", "metal", "aço", "vidro")));
        pontosDeColeta.add(new PontoDeColeta("SUSTENTARE", "Rua E - Bloco 83/84 (Acesso pela farmácia Coelho) - Zona Sul - Distrito Industrial", List.of("papel", "papelão", "alumínio", "plástico", "metal", "aço", "vidro")));
        pontosDeColeta.add(new PontoDeColeta("LAR DA ESPERANÇA", "Av. Goiás", List.of("papel")));

        Usuario usuarioAtual = new Usuario("João", "senha123");

        while (executando) {
            System.out.println("\n--- Ecopoint ---");
            System.out.println("1 - Reciclar");
            System.out.println("2 - Minha Pontuação");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    // Reciclar
                    reciclar(scanner, todosResiduos, pontosDeColeta, usuarioAtual);
                    break;
                case 2:
                    // Mostrar pontuação
                    System.out.println("Você está no nível " + usuarioAtual.getNivel());
                    System.out.println("Total de pontos: " + usuarioAtual.getPontos());
                    break;
                case 3:
                    // Finalizar
                    System.out.println("Obrigado por usar o Ecopoint! Até a próxima.");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void reciclar(Scanner scanner, List<Residuo> residuos, List<PontoDeColeta> pontosDeColeta, Usuario usuarioAtual) {
        System.out.println("\nEscolha um ponto de coleta:");
        for (int i = 0; i < pontosDeColeta.size(); i++) {
            System.out.println((i + 1) + " - " + pontosDeColeta.get(i).getNome());
        }
        System.out.print("Sua escolha: ");
        int escolhaPonto = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (escolhaPonto < 1 || escolhaPonto > pontosDeColeta.size()) {
            System.out.println("Escolha inválida. Tente novamente.");
            return;
        }

        PontoDeColeta pontoSelecionado = pontosDeColeta.get(escolhaPonto - 1);

        // Escolher resíduo
        System.out.println("\nEscolha o resíduo:");
        for (int i = 0; i < residuos.size(); i++) {
            System.out.println((i + 1) + " - " + residuos.get(i).getNome() + " (Ponto por kg: " + residuos.get(i).calcularPontuacao(1) + ")");
        }
        System.out.print("Sua escolha: ");
        int escolhaResiduo = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        if (escolhaResiduo < 1 || escolhaResiduo > residuos.size()) {
            System.out.println("Escolha inválida. Tente novamente.");
            return;
        }

        Residuo residuoSelecionado = residuos.get(escolhaResiduo - 1);

        // Quantidade
        System.out.print("Quantos Kg você deseja reciclar? ");
        double quantidadeKg = scanner.nextDouble();
        scanner.nextLine(); // Consumir nova linha

        // Reciclar
        usuarioAtual.reciclar(residuoSelecionado, quantidadeKg);

        // Perguntar se deseja continuar
        System.out.print("Mais alguma coisa para reciclar? (s/n): ");
        String resposta = scanner.nextLine();
        if (!resposta.equalsIgnoreCase("s")) {
            System.out.println("Voltando ao menu principal...");
        }
    }
}
