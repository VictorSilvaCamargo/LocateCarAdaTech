package Veiculo;

import java.util.ArrayList;

public class VeiculoRepository {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public Veiculo encontrarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null; // Retorna null se não encontrar
    }

    public Veiculo encontrarVeiculoPorNome(String nome) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getNome().equalsIgnoreCase(nome)) {
                return veiculo;
            }
        }
        return null; // Retorna null se não encontrar
    }

    public ArrayList<Veiculo> obterVeiculosDisponiveis() {
        ArrayList<Veiculo> veiculosDisponiveis = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponivel()) {
                veiculosDisponiveis.add(veiculo);
            }
        }
        return veiculosDisponiveis;
    }
}
