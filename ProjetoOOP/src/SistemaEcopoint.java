import java.util.List;

public class SistemaEcopoint {
    public static void main(String[] args) {
        // Criando resíduos
        residuo plastico = new residuo("Plástico", "Reciclável");
        residuo metal = new residuo("Metal", "Reciclável");
        residuo papel = new residuo("Papel", "Reciclável");
        residuo vidro = new residuo("Vidro", "Não Reciclável");

        // Criando um ponto de coleta que aceita plástico e papel
        List<String> tiposAceitos = List.of("Plástico", "Papel");
        pontoDeColeta ponto1 = new pontoDeColeta("Ecoponto Centro", "Av. Principal, 123", tiposAceitos);
        pontoDeColeta ponto2 = new pontoDeColeta("Ecoponto Frei Serafim", "Av. Frei Serafim, 873", tiposAceitos);

        // Exibindo informações do ponto de coleta
        ponto1.exibirInformacoes();
        ponto2.exibirInformacoes();

        System.out.println("==================================\n");

        // Criando o primeiro usuário
        usuario usuario1 = new usuario("Barroso");
        usuario1.descartarResiduo(ponto1, plastico);
        usuario1.descartarResiduo(ponto1, metal);
        usuario1.descartarResiduo(ponto1, papel);
        usuario1.descartarResiduo(ponto1, vidro);

        System.out.println("==================================\n");

        // Criando o segundo usuário
        usuario usuario2 = new usuario("Coelho");
        usuario2.descartarResiduo(ponto2, plastico);
        usuario2.descartarResiduo(ponto2, metal);
        usuario2.descartarResiduo(ponto2, papel);
        usuario2.descartarResiduo(ponto2, vidro);

        System.out.println("==================================\n");


    }
}
