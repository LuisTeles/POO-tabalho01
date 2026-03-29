package br.inatel.pcmania;

public class Computador {
    private String marca;
    private float preco;
    private SistemaOperacional OS;

    // CORREÇÃO 1: A declaração do array não leva o tamanho aqui
    private HardwareBasico[] hardware;

    // Define o Atributo na classe Todo
    private MemoriaUSB memoria;

    // Método que cria a agregação
    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoria = musb;
    }

    // CORREÇÃO 2: Removido 'HardwareBasico[] hardwareInicial' e adicionado as capacidades
    public Computador(String marca, float preco, String nomeOS, int tipoOS, float processadorCap, float ramCap, float hdCap) {
        this.marca = marca;
        this.preco = preco;

        // Composição: o PC cria seu sistema operacional
        this.OS = new SistemaOperacional(nomeOS, tipoOS);

        // CORREÇÃO 3: Inicialização correta do array com tamanho 3
        this.hardware = new HardwareBasico[3];
        this.hardware[0] = new HardwareBasico("Processador", processadorCap);
        this.hardware[1] = new HardwareBasico("Memória RAM", ramCap);
        this.hardware[2] = new HardwareBasico("HD", hdCap);
    }

    public void mostraPCConfigs(){
        System.out.println("\nConfiguração do PC:");
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);

        if (hardware != null && hardware.length > 0) {
            System.out.println("Hardware:");
            for (int i = 0; i < hardware.length; i++) {
                if (hardware[i] != null) {
                    System.out.println("  - " + hardware[i].getNome() + ": " + hardware[i].getCapacidade() +
                            (hardware[i].getNome().contains("Processador") ? " Mhz" : " Gb"));
                }
            }
        }

        if (OS != null) {
            System.out.println("Sistema Operacional: " + OS.getNome() + " (" + OS.getTipo() + " bits)");
        }

        if (memoria != null) {
            System.out.println("Acompanha: " + memoria.getNome() + " de " + memoria.getCapacidade() + "Gb");
        }
    }

    public float getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }
}