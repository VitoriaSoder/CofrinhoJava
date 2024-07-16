package vitoria.soder;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Cofrinho cofrinho;

    // Construtor da classe Menu
    public Menu() {
        scanner = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    // Método para exibir o menu principal e interagir com o usuário
    public void exibirMenuPrincipal() {
        int opcao;

        do {
            exibirOpcoes(); // Exibe as opções do menu
            opcao = lerInteiroEntre(0, 4); // Lê a opção do usuário

            switch (opcao) {
                case 1:
                    menuAdicionarMoeda(); // Chama o método para adicionar moeda
                    break;
                case 2:
                    menuRemoverMoeda(); // Chama o método para remover moeda
                    break;
                case 3:
                    cofrinho.listarMoedas(); // Chama o método para listar todas as moedas
                    break;
                case 4:
                    cofrinho.totalConvertido(); // Chama o método para calcular o total convertido
                    break;
                case 0:
                    System.out.println("Finalizando o programa!!!"); // Mensagem de encerramento do programa
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente."); // Mensagem para opção inválida
                    break;
            }
        } while (opcao != 0);
    }

    // Método para exibir as opções do menu
    private void exibirOpcoes() {
        System.out.println("----------------COFRINHO DA VITORIA SODER----------------");
        System.out.println("1- Adicionar Moeda");
        System.out.println("2- Remover Moeda");
        System.out.println("3- Listar Todas as Moedas");
        System.out.println("4- Calcular Total");
        System.out.println("0- Sair do Programa");
        System.out.print("Escolha uma das opções acima: ");
    }

    // Método para adicionar uma moeda ao cofrinho
    private void menuAdicionarMoeda() {
        cofrinho.adicionar(criarMoeda());
    }

    // Método para remover uma moeda do cofrinho
    private void menuRemoverMoeda() {
        if (!cofrinho.estaVazio()) {
            cofrinho.remover(criarMoeda());
        }
    }

    // Método para criar uma nova moeda com base na escolha do usuário
    private Moeda criarMoeda() {
        Moeda moeda = null;
        int opcao;
        double valor;

        do {
            System.out.println("--------------Tipo da Moeda-------------");
            System.out.println("1- Real");
            System.out.println("2- Dólar");
            System.out.println("3- Euro");
            System.out.print("Escolha um tipo de Moeda acima: ");
            opcao = lerInteiroEntre(1, 3); // Lê a escolha do tipo de moeda
        } while (opcao < 1 || opcao > 3);

        valor = lerDoublePositivo(); // Lê o valor da moeda

        switch (opcao) {
            case 1:
                moeda = new Real(valor); // Cria uma moeda do tipo Real
                break;
            case 2:
                moeda = new Dolar(valor); // Cria uma moeda do tipo Dólar
                break;
            case 3:
                moeda = new Euro(valor); // Cria uma moeda do tipo Euro
                break;
        }

        return moeda;
    }

    // Método para ler um inteiro dentro de um intervalo específico
    private int lerInteiroEntre(int min, int max) {
        int valor;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next();
            }
            valor = scanner.nextInt();
            if (valor < min || valor > max) {
                System.out.printf("Por favor, digite um número entre %d e %d.\n", min, max);
            }
        } while (valor < min || valor > max);

        return valor;
    }

    // Método para ler um valor double positivo
    private double lerDoublePositivo() {
        double valor;

        do {
            System.out.print("Digite o valor: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, digite um valor numérico válido.");
                scanner.next();
            }
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Por favor, digite um valor positivo.");
            }
        } while (valor <= 0);

        return valor;
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenuPrincipal();
    }
}
