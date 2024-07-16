package vitoria.soder;

public class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }

    // Método para exibir informações sobre a moeda Real
    @Override
    public void info() {
        System.out.printf("Real - R$ %.2f\n", valor);
    }

    // Método para converter o valor da moeda Real (já está em reais)
    @Override
    public double converter() {
        return valor;
    }
}
