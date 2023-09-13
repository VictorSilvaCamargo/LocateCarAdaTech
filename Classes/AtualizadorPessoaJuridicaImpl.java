package Classes;

public class AtualizadorPessoaJuridicaImpl implements AtualizadorPessoaJuridica {
    private BuscadorPessoaJuridica buscador;

    public AtualizadorPessoaJuridicaImpl(BuscadorPessoaJuridica buscador) {
        this.buscador = buscador;
    }

    public boolean atualizarPessoaJuridica(String cnpj, String novoNome, String novoSobrenome) {
        // Implemente a lógica de atualização de Pessoa Jurídica aqui
        PessoaJuridica pessoaJuridica = buscador.buscarPessoaJuridicaPorCNPJ(cnpj);
        if (pessoaJuridica != null) {
            pessoaJuridica.setNome(novoNome);
            pessoaJuridica.setSobrenome(novoSobrenome);
            return true;
        }
        return false;
    }
}
