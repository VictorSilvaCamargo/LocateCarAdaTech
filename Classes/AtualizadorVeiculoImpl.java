package Classes;

public class AtualizadorVeiculoImpl implements AtualizadorVeiculo {
    private BuscadorVeiculo buscador;

    public AtualizadorVeiculoImpl(BuscadorVeiculo buscador) {
        this.buscador = buscador;
    }

    public boolean atualizarVeiculo(String placa, String novoNome, String novoTipo) {
        // Implemente a lógica de atualização de Veículo aqui
        Veiculo veiculo = buscador.buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculo.setNome(novoNome);
            veiculo.setTipo(novoTipo);
            return true;
        }
        return false;
    }
}

