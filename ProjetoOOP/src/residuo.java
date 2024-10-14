public class residuo {
    private String tipo;
    private String categoria;

    public residuo(String tipo, String categoria) {
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return "Tipo: " + tipo + ", Categoria: " + categoria;
    }
}
