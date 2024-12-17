package Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar){
            System.out.println("Escolha um a opção: ");
            System.out.println("1 - Fazer um novo pedido ");
            System.out.println("2 - Alterar um pedido ");
            System.out.println("3 - Adicionar um cliente ");
            System.out.println("4 - Gerar relatório de vendas ");
            System.out.println("9 - Sair");

            System.out.print("Opção ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    alterarPedido();
                    break;
                case 3:
                    adicionarCliente();
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 9:
                    System.out.println("Até amanhã...");
                    continuar = false;
                    break;
                default:
                    break;
            }
        }

    }

    private static void fazerPedido() {
        System.out.println("Fazer pedido");
    }

    private static void alterarPedido() {
        System.out.println("Alterar Pedido");
    }
    private static void adicionarCliente() {
        System.out.println("Adicionar cliente");
    }

    private static void gerarRelatorio() {
        System.out.println("gerar relatorio");
    }

}
