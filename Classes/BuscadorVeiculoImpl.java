package Classes;

public class BuscadorVeiculoImpl implements BuscadorVeiculo {
    private VeiculoRepository veiculoRepository;

    public BuscadorVeiculoImpl(VeiculoRepository repository) {
        this.veiculoRepository = repository;
    }

    @Override
    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculoRepository.encontrarVeiculoPorPlaca(placa);
    }
}
