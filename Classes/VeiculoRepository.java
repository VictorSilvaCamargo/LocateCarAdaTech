package Classes;
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

}
