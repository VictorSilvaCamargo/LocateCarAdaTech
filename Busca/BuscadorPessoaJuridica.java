package Busca;

import Pessoa.PessoaFisica;
import Pessoa.PessoaJuridica;

public interface BuscadorPessoaJuridica {
    PessoaJuridica buscarPessoaJuridicaPorCNPJ(String cnpj);

    interface BuscadorPessoaFisica {
        PessoaFisica buscarPessoaFisicaPorCPF(String cpf);
    }
}
