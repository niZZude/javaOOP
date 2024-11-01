import java.util.List;

class Usuario {
    private String nome;
    private int nivel;
    private int pontos;

    public Usuario(String nome) {
        this.nome = nome;
        this.nivel = 1; // Nível inicial
        this.pontos = 0; // Pontos iniciais
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void descartarResiduos(PontoDeColeta ponto, List<Residuo> residuos) {
        for (Residuo residuo : residuos) {
            pontos += residuo.calcularPontuacao(); // Acumula pontos
            System.out.println("Você descartou " + residuo.getNome() + " e ganhou " + residuo.calcularPontuacao() + " pontos.");
        }
        verificarNivel(); // Verifica se o usuário subiu de nível
    }

    private void verificarNivel() {
        if (pontos >= 50) { // Exemplo de condição para subir de nível
            nivel++;
            pontos = 0; // Reseta pontos após subir de nível
            System.out.println("Parabéns, " + nome + "! Você subiu para o nível " + nivel + "!");
        }
    }
}
