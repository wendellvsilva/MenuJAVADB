import java.util.Scanner;
import java.util.Random;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int escolha;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Ler números até que você digite 10");
            System.out.println("2 - Verificar se uma pessoa é maior de idade");
            System.out.println("3 - Calcular a tabuada de um número");
            System.out.println("4 - Gerar 10 números aleatórios entre 0 e 100");
            System.out.println("5 - Jogar Pedra, Papel ou Tesoura");
            System.out.println("6 - Calcular o preço total de um produto");
            System.out.println("0 - Sair");
            escolha = scanner.nextInt();

            switch(escolha) {
                case 1:
                    lerNumeros(scanner);
                    break;
                case 2:
                    verificarIdade(scanner);
                    break;
                case 3:
                    calcularTabuada(scanner);
                    break;
                case 4:
                    gerarNumerosAleatorios(random);
                    break;
                case 5:
                    jogarJokenpo(scanner, random);
                    break;
                case 6:
                    calcularPrecoTotal(scanner);
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
            }
        } while(escolha != 0);

        scanner.close();
    }

    public static void lerNumeros(Scanner scanner) {
        System.out.println("Digite números (digite 10 para sair):");
        int numero;
        do {
            numero = scanner.nextInt();
        } while (numero != 10);
    }

    public static void verificarIdade(Scanner scanner) {
        System.out.println("Digite a idade:");
        int idade = scanner.nextInt();
        if (idade >= 18) {
            System.out.println("Você tem " + idade + " anos e é maior de idade.");
        } else {
            System.out.println("Você tem " + idade + " anos e é menor de idade.");
        }
    }

    public static void calcularTabuada(Scanner scanner) {
        System.out.println("Digite um número:");
        int numero = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    public static void gerarNumerosAleatorios(Random random) {
        System.out.print("Números gerados: ");
        int[] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = random.nextInt(101);
            System.out.print(numeros[i] + " ");
        }
        int min = numeros[0];
        int max = numeros[0];
        for (int i = 1; i < 10; i++) {
            if (numeros[i] < min) {
                min = numeros[i];
            }
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        System.out.println("\nMenor número: " + min);
        System.out.println("Maior número: " + max);
    }

    public static void jogarJokenpo(Scanner scanner, Random random) {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Pedra");
        System.out.println("2. Papel");
        System.out.println("3. Tesoura");
        int escolhaJogador = scanner.nextInt();
        int escolhaComputador = random.nextInt(3) + 1;
        if (escolhaJogador == escolhaComputador) {
            System.out.println("Empate!");
        } else if ((escolhaJogador == 1 && escolhaComputador == 3) ||
                (escolhaJogador == 2 && escolhaComputador == 1) ||
                (escolhaJogador == 3 && escolhaComputador == 2)) {
            System.out.println("Você ganhou!");
        } else {
            System.out.println("Você perdeu!");
        }
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        String nomeProduto = scanner.next();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade comprada:");
        int quantidade = scanner.nextInt();

        double precoTotal;
        if (quantidade <= 10) {
            precoTotal = preco * quantidade;
        } else if (quantidade <= 20) {
            precoTotal = preco * quantidade * 0.9;
        } else if (quantidade <= 50) {
            precoTotal = preco * quantidade * 0.8;
        } else {
            precoTotal = preco * quantidade * 0.75;
        }

        System.out.println("Produto: " + nomeProduto);
        System.out.println("Total a ser pago: " + precoTotal);
    }
}