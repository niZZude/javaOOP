import java.util.List;

public class pontoDeColeta {
    private String nome;
    private String endereco;
    private List<String> tiposAceitos;

    // Construtor
    public pontoDeColeta(String nome, String endereco, List<String> tiposAceitos) {
        this.nome = nome;
        this.endereco = endereco;
        this.tiposAceitos = tiposAceitos;
    }

    // Método getter para o nome
    public String getNome() {
        return nome;
    }

    // Exibir informações do ponto de coleta
    public void exibirInformacoes() {
        System.out.println("Ponto de Coleta: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Tipos aceitos: " + String.join(", ", tiposAceitos));
    }

    // Método que verifica se o ponto aceita o tipo de resíduo
    public boolean aceitaResiduo(String tipoResiduo) {
        return tiposAceitos.contains(tipoResiduo);
    }
}
