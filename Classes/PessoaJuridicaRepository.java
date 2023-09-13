package Classes;
import java.util.ArrayList;

public class PessoaJuridicaRepository implements CNPJverificador{
    private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public void adicionarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
    }

    public void imprimirPessoasJuridicas() {
        for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
            System.out.println("Nome: " + pessoaJuridica.getNome());
            System.out.println("Sobrenome: " + pessoaJuridica.getSobrenome());
            System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
            System.out.println();
        }
    }

    public boolean verificarCNPJ(String cnpj) {
        for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
            if (pessoaJuridica.getCnpj().equals(cnpj)) {
                return true;
            }
        }
        return false;
    }

    public PessoaJuridica encontrarPessoaPorCNPJ(String cnpj) {
        for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
            if (pessoaJuridica.getCnpj().equals(cnpj)) {
                return pessoaJuridica;
            }
        }
        return null; // Retorna null se não encontrar
    }
}
