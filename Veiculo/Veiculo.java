package Veiculo;

public class Veiculo {
    private String nome;
    private String placa;
    private String tipo;
    private boolean disponivel;

    public Veiculo(String nome, String placa, String tipo) {
        this.nome = nome;
        this.placa = placa;
        this.tipo = tipo;
        this.disponivel = true; // Por padrão, o veículo está disponível quando criado.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        if (!disponivel) {
            System.out.println("Este veículo já está reservado.");
        } else {
            disponivel = false;
        }
    }

    public void liberar() {
        disponivel = true;
    }
}
