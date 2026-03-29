package br.inatel.pcmania;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int matricula = 2223;
        Scanner input = new Scanner(System.in);
        int option = -1;
        Cliente cliente01 = new Cliente("Luis Antonio Ribeiro Teles", "123.456.789-00");

        Computador promo1 = new Computador("Apple", matricula, "macOS Sequoia", 64, 2200, 8, 500);
        MemoriaUSB usbPromo1 = new MemoriaUSB("Pen-drive", 16);
        promo1.addMemoriaUSB(usbPromo1);

        Computador promo2 = new Computador("Samsung", matricula+1234, "Windows 8", 64, 3370, 16, 1000);
        MemoriaUSB usbPromo2 = new MemoriaUSB("Pen-drive", 32);
        promo2.addMemoriaUSB(usbPromo2);

        Computador promo3 = new Computador("Dell", matricula+5678, "Windows 10", 64, 4500, 32, 2000);
        MemoriaUSB usbPromo3 = new MemoriaUSB("HD Externo", 1000);
        promo3.addMemoriaUSB(usbPromo3);

        System.out.println("=== Bem-vindo à PC Mania ===");
        System.out.println("Para Promoção 1 digite 1");
        System.out.println("Para Promoção 2 digite 2");
        System.out.println("Para Promoção 3 digite 3");
        System.out.println("Para sair do sistema digite 0");
        System.out.println();

        while (true) {
            System.out.print("Digite sua opção: ");
            option = input.nextInt();

            if (option == 0) {
                //Refatoração para garantir que a condição de 2..* do UML seja executada corretamente
                // Verificando a regra UML do 2..*
                if (cliente01.getTotalComputadores() < 2) {
                    System.out.println("Atenção: A promoção exige a compra de no mínimo 2 computadores!");
                    System.out.println("Você tem apenas " + cliente01.getTotalComputadores() + " no carrinho.\n");
                    continue; // Pula o resto do loop e volta a pedir uma opção
                } else {
                    break; // Se tiver 2 ou mais, sai do loop e vai para o recibo
                }
            }

            switch (option) {
                case 1:
                    cliente01.adicionarComputador(promo1);
                    System.out.println("Promoção 1 - Apple adicionada ao carrinho!");
                    break;
                case 2:
                    cliente01.adicionarComputador(promo2);
                    System.out.println("Promoção 2 - Samsung adicionada ao carrinho!");
                    break;
                case 3:
                    cliente01.adicionarComputador(promo3);
                    System.out.println("Promoção 3 - Dell adicionada ao carrinho!");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        // Exibir informações finais
        System.out.println("\n=== Informações da Compra ===");
        System.out.println("Cliente: " + cliente01.getNome());
        System.out.println("CPF: " + cliente01.getCpf());
        System.out.println("\nComputadores adquiridos:");
        
        for (int i = 0; i < cliente01.getTotalComputadores(); i++) {
            Computador pc = cliente01.getComputadores()[i];
            if (pc != null) {
                pc.mostraPCConfigs();
            }
        }
        
        System.out.println("\n=============================");
        System.out.println("Total da compra: R$ " + cliente01.calculaTotalCompra());
        System.out.println("=============================");
        
        // Processar o pedido
        ProcessarPedido.enviarPedido(cliente01.getComputadores());
        
        input.close();
    }
}
