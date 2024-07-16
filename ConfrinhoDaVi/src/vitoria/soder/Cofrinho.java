package vitoria.soder;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    private List<Moeda> listaMoedas = new ArrayList<>();

    // Método para adicionar uma moeda ao cofrinho
    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
        System.out.println("*** Moeda adicionada no Cofrinho da Vitoria! ***");
    }

    // Método para remover uma moeda do cofrinho
    public void remover(Moeda moeda) {
        if (!estaVazio()) {
            int contador = 0;
            // Conta quantas moedas com o mesmo valor existem no cofrinho
            for (Moeda m : listaMoedas) {
                if (moeda.equals(m)) {
                    contador++;
                }
            }
            // Se houver pelo menos uma moeda com o mesmo valor, remove uma delas
            if (contador > 0) {
                listaMoedas.remove(moeda);
                System.out.println("*** Moeda removida do Cofrinho! ***");
            } else {
                // Caso contrário, informa que não existe moeda com aquele valor no cofrinho
                System.out.println("*** Não existe moeda no Cofrinho com este valor! ***");
            }
        }
    }

    // Método para listar todas as moedas no cofrinho
    public void listarMoedas() {
        if (!estaVazio()) {
            System.out.println("------------- Listar moedas -------------");
            for (Moeda moeda : listaMoedas) {
                moeda.info();
            }
        }
    }

    // Método para calcular o total convertido das moedas em reais
    public void totalConvertido() {
        if (!estaVazio()) {
            double valorTotal = 0;
            for (Moeda moeda : listaMoedas) {
                valorTotal += moeda.converter();
            }
            System.out.printf("Total convertido em Reais: R$ %.2f\n", valorTotal);
        }
    }

    // Método para verificar se o cofrinho está vazio
    public boolean estaVazio() {
        if (listaMoedas.isEmpty()) {
            System.out.println("*** Não existe moeda no Cofrinho! ***");
            return true;
        }
        return false;
    }
}
