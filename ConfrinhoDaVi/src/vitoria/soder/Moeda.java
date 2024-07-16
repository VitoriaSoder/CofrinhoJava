package vitoria.soder;

import java.util.Objects;

public abstract class Moeda {
    protected double valor; // Modificada para protected para que as classes filhas possam acessá-la diretamente

    public Moeda(double valor) {
        this.valor = valor;
    }

    // Métodos abstratos a serem implementados pelas classes filhas
    abstract void info();
    abstract double converter();

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Moeda outraMoeda = (Moeda) obj;
        return Double.compare(outraMoeda.valor, valor) == 0;
    }
}
