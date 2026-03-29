public class Cliente {
    private String nome;
    private String cpf;
    //Arrays de computados associa o usuário com computadores.
    private Computador[] computador;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {return nome;}

    public float calculaTotalCompra(){
        return 0;
    }

}
