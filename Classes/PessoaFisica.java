package Classes;

public class PessoaFisica extends Pessoa{
     private String cpf;

    public PessoaFisica(String nome, String sobrenome, String cpf) {
        super(nome, sobrenome);
        this.cpf = cpf;

    }
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getSobrenome(){
        return sobrenome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
