package Aluguel;
import Pessoa.Pessoa;
import Veiculo.Veiculo;
import Veiculo.VeiculoRepository;

import java.time.LocalDateTime;

public class AluguelManager {
    private VeiculoRepository veiculoRepository;
    private AluguelRepository aluguelRepository;

    public AluguelManager(VeiculoRepository veiculoRepository, AluguelRepository aluguelRepository) {
        this.veiculoRepository = veiculoRepository;
        this.aluguelRepository = aluguelRepository;
    }

    public Aluguel alugarVeiculo(Pessoa cliente, String placaVeiculo, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        Veiculo veiculo = veiculoRepository.encontrarVeiculoPorPlaca(placaVeiculo);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return null;
        }

        if (!veiculo.isDisponivel()) {
            System.out.println("Veículo não está disponível para aluguel.");
            return null;
        }

        veiculo.reservar();

        Aluguel aluguel = new Aluguel(veiculo, cliente, dataHoraInicio, dataHoraFim);
        aluguelRepository.adicionarAluguel(aluguel);

        return aluguel;
    }

}
