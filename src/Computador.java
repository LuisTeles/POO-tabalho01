public class Computador {
    private String marca ;
    private float preco;
    private SistemaOperacional OS;
    private HardwareBasico[] hardware;

    //Define o Atributo na classe Todo
    private MemoriaUSB memoria;

    //Método que cria a agregação
    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoria = musb;
    }

    public Computador(String marca, float preco, String nomeOS, int tipoOS, HardwareBasico[] hardwareInicial) {
        this.marca = marca;
        this.preco = preco;

        //Composição: o PC cria seu sistema operacional
        this.OS = new SistemaOperacional(nomeOS, tipoOS);
        //Composição: o PC cria seu hardware
        this.hardware = hardwareInicial;
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

