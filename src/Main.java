import java.util.Scanner;

public class Main {
    static void main() {
        int matricula = 2223;
        Scanner input = new Scanner(System.in);
        int option = -1;
        Cliente Cliente01 = new Cliente("Luis", "123.456.789-00");

        System.out.println("Para promoção 1 digite 1");
        System.out.println("Para promoção 2 digite 2");
        System.out.println("Para promoção 3 digite 3");
        System.out.println("Para sair do sistema digite 0");
        while (true) {
            option = input.nextInt();

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("1");
                    ProcessarPedido.enviarPedido(Cliente01.getComputador());
                    break;
                case 2:
                    System.out.println("2");
                    ProcessarPedido.enviarPedido(Cliente01.getComputador());
                    break;
                case 3:
                    System.out.println("3");
                    ProcessarPedido.enviarPedido(Cliente01.getComputador());
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

        }
    }
}
