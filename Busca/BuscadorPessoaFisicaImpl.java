package Busca;

import Pessoa.PessoaFisica;
import Pessoa.PessoaFisicaRepository;

public class BuscadorPessoaFisicaImpl implements BuscadorPessoaJuridica.BuscadorPessoaFisica {
    private PessoaFisicaRepository pessoaFisicaRepository;

    public BuscadorPessoaFisicaImpl(PessoaFisicaRepository repository) {
        this.pessoaFisicaRepository = repository;
    }

    @Override
    public PessoaFisica buscarPessoaFisicaPorCPF(String cpf) {
        return pessoaFisicaRepository.encontarPessoaPorCPF(cpf);
    }
}
