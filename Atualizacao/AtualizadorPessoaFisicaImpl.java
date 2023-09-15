package Atualizacao;

import Busca.BuscadorPessoaJuridica;
import Pessoa.PessoaFisica;

public class AtualizadorPessoaFisicaImpl implements AtualizadorPessoaFisica {
    private BuscadorPessoaJuridica.BuscadorPessoaFisica buscador;

    public AtualizadorPessoaFisicaImpl(BuscadorPessoaJuridica.BuscadorPessoaFisica buscador) {
        this.buscador = buscador;
    }

    public boolean atualizarPessoaFisica(String cpf, String novoNome, String novoSobrenome) {

        PessoaFisica pessoaFisica = buscador.buscarPessoaFisicaPorCPF(cpf);
        if (pessoaFisica != null) {
            pessoaFisica.setNome(novoNome);
            pessoaFisica.setSobrenome(novoSobrenome);
            return true;
        }
        return false;
    }
}