package Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaCliente = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        boolean continuar = true;

        while (continuar){
            System.out.println("Escolha um a opção: ");
            System.out.println("1 - Fazer um novo pedido ");
            System.out.println("2 - Alterar um pedido ");
            System.out.println("3 - Adicionar um cliente ");
            System.out.println("4 - Gerar relatório de vendas ");
            System.out.println("5 - Gerar lista de clientes");
            System.out.println("9 - Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao){
                case 1:
                    fazerPedido(scanner, listaPedidos, listaCliente);
                    break;
                case 2:
                    alterarPedido();
                    break;
                case 3:
                    listaCliente.add(adicionarCliente(scanner));
                    System.out.println("Cliente adicionado com sucesso! ");
                    System.out.println();
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 5:
                    gerarListaClientes(listaCliente);
                    break;
                case 9:
                    System.out.println("Até amanhã...");
                    continuar = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
        }

    }


    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedido, List<Cliente> listaClientes) {
        List<Pizza> pizzas = new ArrayList<>();
        System.out.println("Fazer pedido");
        int x = 1;
        System.out.println("Selecione um cliente: ");
        for (Cliente cliente : listaClientes){
            System.out.println(x + " - " + cliente.getNome());
            x++;
        }
        System.out.println("Opção: ");
        int cliente = scanner.nextInt();
        scanner.nextLine();

        boolean continuar = true;
        while (continuar) {

            x = 1;
            System.out.println("Qual o tamanho da pizza? ");
            System.out.println("Selecione um tamanho ");
            for (Pizza.TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                System.out.println(x + " - " + tamanhos);
                x++;
            }
            System.out.println("Opção: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            int quantidadeSabores = 0;

            while (quantidadeSabores < 1 || quantidadeSabores > 4) {
                System.out.println("Digite a quantidade de sabores: 1 - 4 ");
                System.out.println("Opcão: ");
                quantidadeSabores = scanner.nextInt();
                scanner.nextLine();
            }

            Cardapio cardapio = new Cardapio();
            List<String> saboresList = new ArrayList<>();
            List<String> saboresSelecionados = new ArrayList<>();

            for (int i = 0; i < quantidadeSabores; i++) {
                x = 1;
                System.out.println("Selecione o sabor da pizza: ");
                for (String sabor : cardapio.getCardapio().keySet()) {
                    saboresList.add(sabor);
                    System.out.println(x + " - " + sabor);
                    x++;
                }
                System.out.println("Opção: ");
                int sabor = scanner.nextInt();
                scanner.nextLine();
                saboresSelecionados.add(saboresList.get(sabor - 1));

            }
            Pizza pizza = new Pizza(saboresSelecionados, cardapio.getPrecoJusto(saboresSelecionados), Pizza.TamanhoPizza.getByIndex(tamanho - 1));
            pizzas.add(pizza);
        }
        Pedido pedido = new Pedido(listaPedido.size() + 1, listaClientes.get(cliente - 1), pizzas, somaPizzas(pizzas));
        listaPedido.add(pedido);

        System.out.println("Pedido adicionado com sucesso! ");
        System.out.println();
        System.out.println("Deseja cadastrar outro pedido? ");
        System.out.println("1 - Sim ");
        System.out.println("2 - Não ");
        System.out.println("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 2){
            continuar = false;
        }
    }

    private static double somaPizzas(List<Pizza> pizzas) {
        double total = 0;
        for (Pizza pizza : pizzas){
            total += pizza.getPreco();
        }
        return total;
    }

    private static void alterarPedido() {
        System.out.println("Alterar Pedido");
    }
    private static Cliente adicionarCliente(Scanner scanner) {
        System.out.println("Adicionar cliente");
        System.out.println();
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println();

        return new Cliente(nome,endereco,telefone,email);
    }

    private static void gerarRelatorio() {
        System.out.println("gerar relatorio");
    }

    private static void gerarListaClientes(List<Cliente> listaClientes) {
        int x = 1;
        if (listaClientes.isEmpty()){
            System.out.println("A lista de clientes está vazia. ");
            System.out.println();
        }

        for (Cliente cliente : listaClientes ){
            System.out.println("Cliente " + x);
            System.out.println(cliente.getNome());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getEndereco());
            System.out.println(cliente.getTelefone());
            System.out.println();
            x++;
        }
    }


}
