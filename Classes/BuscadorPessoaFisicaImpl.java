package Classes;

public class BuscadorPessoaFisicaImpl implements BuscadorPessoaFisica {
    private PessoaFisicaRepository pessoaFisicaRepository;

    public BuscadorPessoaFisicaImpl(PessoaFisicaRepository repository) {
        this.pessoaFisicaRepository = repository;
    }

    @Override
    public PessoaFisica buscarPessoaFisicaPorCPF(String cpf) {
        return pessoaFisicaRepository.encontarPessoaPorCPF(cpf);
    }
}
