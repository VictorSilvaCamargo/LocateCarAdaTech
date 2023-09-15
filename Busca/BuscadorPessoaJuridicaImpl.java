package Busca;

import Pessoa.PessoaJuridica;
import Pessoa.PessoaJuridicaRepository;

public class BuscadorPessoaJuridicaImpl implements BuscadorPessoaJuridica {
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public BuscadorPessoaJuridicaImpl(PessoaJuridicaRepository repository) {
        this.pessoaJuridicaRepository = repository;
    }

    @Override
    public PessoaJuridica buscarPessoaJuridicaPorCNPJ(String cnpj) {
        return pessoaJuridicaRepository.encontrarPessoaPorCNPJ(cnpj);
    }
}
