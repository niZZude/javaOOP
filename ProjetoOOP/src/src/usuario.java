import java.util.List;

public class usuario {
    private String nome;

    public usuario(String nome) {
        this.nome = nome;
    }

    // Método que descarta múltiplos resíduos em um ponto de coleta
    public void descartarResiduos(pontoDeColeta ponto, List<residuo> residuos) {
        for (residuo r : residuos) {
            if (ponto.aceitaResiduo(r.getTipo())) {
                System.out.println(nome + " descartou " + r.getTipo() + " no " + ponto.getNome());
            } else {
                System.out.println(nome + " tentou descartar " + r.getTipo() + " no " + ponto.getNome() +
                        ", mas este ponto não aceita esse tipo de resíduo.");
            }
        }
    }
}
