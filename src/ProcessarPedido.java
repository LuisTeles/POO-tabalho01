public class ProcessarPedido {
    public static void enviarPedido(Computador[] computador) {
        //Verifica se existem computadores no pedidos
        // ToDo UML possui mínimo de dois pedido na relação entre cliente e computador (2..*) portanto esta logica provavelmente tera que ser diferente
        if (computador != null) {
            System.out.println("Pedido enviado...");
        } else  {
            System.out.println("Erro: Não há computadores no carrinho para enviar o pedido.");
        }
    }
}
