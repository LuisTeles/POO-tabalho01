package br.inatel.pcmania;

public class Cliente {
    private String nome;
    private String cpf;
    //Arrays de computados associa o usuário com computadores.
    private Computador[] computadores = new Computador[100];
    private int totalComputadores = 0;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {return nome;}
    
    public String getCpf() {return cpf;}

    public void adicionarComputador(Computador pc) {
        if (totalComputadores < computadores.length) {
            computadores[totalComputadores] = pc;
            totalComputadores++;
        }
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < totalComputadores; i++) {
            if (computadores[i] != null) {
                total += computadores[i].getPreco();
            }
        }
        return total;
    }

    public Computador[] getComputadores() {
        return computadores;
    }
    
    public int getTotalComputadores() {
        return totalComputadores;
    }

}
