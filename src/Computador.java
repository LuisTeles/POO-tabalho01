public class Computador {
    private String marca ;
    private float preco;
    private SistemaOperacional OS;
    private HardwareBasico hardware;

    //Define o Atributo na classe Todo
    private MemoriaUSB memoria;

    //Método que cria a agregação
    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoria = musb;
    }

    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;

        //Composição: o PC "cria" seu sistema operacional
        this.OS = new SistemaOperacional();
        this.hardware = new HardwareBasico();
    }

    public void mostrarPCConfig(){

    }
}
