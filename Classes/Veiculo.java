package Classes;

public class Veiculo {
    private String nome;
    private String placa;
    private String tipo;

    public Veiculo(String nome, String placa, String tipo) {
        this.nome = nome;
        this.placa = placa;
        this.tipo = tipo;
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
}
