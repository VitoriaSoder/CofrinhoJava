package vitoria.soder;

public class Euro extends Moeda {
    private static final double TAXA_DE_CAMBIO = 6.20; // Taxa de câmbio atualizada para o euro

    // Construtor da classe Euro
    public Euro(double valor) {
        super(valor); // Chama o construtor da classe mãe Moeda
    }

    // Método para exibir informações sobre o euro
    @Override
    public void info() {
        System.out.printf("Euro - %.2f\n", valor);
    }

    // Método para converter o valor do euro para reais
    @Override
    public double converter() {
        return valor * TAXA_DE_CAMBIO; // Retorna o valor convertido com base na taxa de câmbio
    }
}
