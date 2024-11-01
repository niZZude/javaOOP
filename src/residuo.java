// Classe abstrata Residuo
abstract class Residuo {
    private String nome;
    private String tipo;

    public Residuo(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    // Método abstrato para cálculo de pontuação
    public abstract int calcularPontuacao();
}

// Subclasses específicas de resíduos com polimorfismo
class Plastico extends Residuo {
    public Plastico() {
        super("Plástico", "Reciclável");
    }

    @Override
    public int calcularPontuacao() {
        return 10; // Pontuação para plástico
    }
}

class Metal extends Residuo {
    public Metal() {
        super("Metal", "Reciclável");
    }

    @Override
    public int calcularPontuacao() {
        return 15; // Pontuação para metal
    }
}

class Papel extends Residuo {
    public Papel() {
        super("Papel", "Reciclável");
    }

    @Override
    public int calcularPontuacao() {
        return 5; // Pontuação para papel
    }
}

class Vidro extends Residuo {
    public Vidro() {
        super("Vidro", "Não Reciclável");
    }

    @Override
    public int calcularPontuacao() {
        return 0; // Pontuação para vidro, que não é reciclável
    }
}
