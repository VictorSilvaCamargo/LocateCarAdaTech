package Classes;

import java.util.ArrayList;

public class PessoaFisicaRepository implements CPFverificador {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public void adicionarPessoaFisica(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    public void imprimirPessoasFisicas() {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            System.out.println("Nome: " + pessoaFisica.getNome());
            System.out.println("Sobrenome: " + pessoaFisica.getSobrenome());
            System.out.println("CNPJ: " + pessoaFisica.getCpf());
            System.out.println();
        }
    }

    @Override
    public boolean verificarCPF(String cpf) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (pessoaFisica.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public PessoaFisica encontarPessoaPorCPF(String cpf) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (pessoaFisica.getCpf().equals(cpf)) {
                return pessoaFisica;
            }
        }
        return null;
    }
}

