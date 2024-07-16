package vitoria.soder;

public class Dolar extends Moeda {
    private static final double TAXA_DE_CAMBIO = 5.02; // Taxa de câmbio atualizada para o dólar

    // Construtor da classe Dolar
    public Dolar(double valor) {
        super(valor); // Chama o construtor da classe mãe Moeda
    }

    // Método para exibir informações sobre o dólar
    @Override
    public void info() {
        System.out.printf("Dólar - %.2f\n", valor);
    }

    // Método para converter o valor do dólar para reais
    @Override
    public double converter() {
        return valor * TAXA_DE_CAMBIO; // Retorna o valor convertido com base na taxa de câmbio
    }
}
