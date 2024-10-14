import java.util.List;

public class pontoDeColeta {
    private String nome;
    private String localizacao;
    private List<String> tiposDeResiduosAceitos;

    public pontoDeColeta(String nome, String localizacao, List<String> tiposDeResiduos) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.tiposDeResiduosAceitos = tiposDeResiduos;
    }

    public boolean aceitaResiduo(String tipo) {
        return tiposDeResiduosAceitos.contains(tipo);
    }

    public void exibirInformacoes() {
        System.out.println(this);  // Chama o método toString() automaticamente
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Localização: " + localizacao + "\n" +
                "Resíduos aceitos: " + tiposDeResiduosAceitos;
    }
}
