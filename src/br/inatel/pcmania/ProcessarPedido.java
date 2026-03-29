package br.inatel.pcmania;

public class ProcessarPedido {
    public static void enviarPedido(Computador[] computadores) {
        if (computadores != null && computadores.length > 0) {
            boolean temComputador = false;
            for (int i = 0; i < computadores.length; i++) {
                if (computadores[i] != null) {
                    temComputador = true;
                    break;
                }
            }
            
            if (temComputador) {
                System.out.println("Pedido enviado...");
            } else {
                System.out.println("Erro: Não há computadores no carrinho para enviar o pedido.");
            }
        } else {
            System.out.println("Erro: Não há computadores no carrinho para enviar o pedido.");
        }
    }
}
