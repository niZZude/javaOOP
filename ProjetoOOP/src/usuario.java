public class usuario {
    private String nome;

    public usuario(String nome) {
        this.nome = nome;
    }

    public void descartarResiduo(pontoDeColeta ponto, residuo residuo) {
        if (ponto.aceitaResiduo(residuo.getTipo())) {
            System.out.println(nome + " descartou " + residuo.getDescricao() + " no ponto:\n" + ponto);
        } else {
            System.out.println("Este ponto não aceita o resíduo: " + residuo.getTipo());
        }
    }
}
