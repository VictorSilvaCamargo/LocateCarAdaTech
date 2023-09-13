package Classes;

public class AtualizadorPessoaFisicaImpl implements AtualizadorPessoaFisica {
    private BuscadorPessoaFisica buscador;

    public AtualizadorPessoaFisicaImpl(BuscadorPessoaFisica buscador) {
        this.buscador = buscador;
    }

    public boolean atualizarPessoaFisica(String cpf, String novoNome, String novoSobrenome) {
        // Implemente a lógica de atualização de Pessoa Física aqui
        PessoaFisica pessoaFisica = buscador.buscarPessoaFisicaPorCPF(cpf);
        if (pessoaFisica != null) {
            pessoaFisica.setNome(novoNome);
            pessoaFisica.setSobrenome(novoSobrenome);
            return true;
        }
        return false;
    }
}