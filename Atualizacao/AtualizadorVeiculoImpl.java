package Atualizacao;

import Busca.BuscadorVeiculo;
import Veiculo.Veiculo;

public class AtualizadorVeiculoImpl implements AtualizadorVeiculo {
    private BuscadorVeiculo buscador;

    public AtualizadorVeiculoImpl(BuscadorVeiculo buscador) {
        this.buscador = buscador;
    }

    public boolean atualizarVeiculo(String placa, String novoNome, String novoTipo) {

        Veiculo veiculo = buscador.buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculo.setNome(novoNome);
            veiculo.setTipo(novoTipo);
            return true;
        }
        return false;
    }
}

