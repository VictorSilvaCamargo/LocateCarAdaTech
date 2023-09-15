package Devolucao;
import Calculo.*;
import Aluguel.*;
import Veiculo.VeiculoRepository;

import java.time.LocalDateTime;

public class DevolucaoManager {
    private VeiculoRepository veiculoRepository;
    private AluguelRepository aluguelRepository;
    private DevolucaoRepository devolucaoRepository;

    public DevolucaoManager(VeiculoRepository veiculoRepository, AluguelRepository aluguelRepository, DevolucaoRepository devolucaoRepository) {
        this.veiculoRepository = veiculoRepository;
        this.aluguelRepository = aluguelRepository;
        this.devolucaoRepository = devolucaoRepository;
    }

    public Devolucao devolverVeiculo(Aluguel aluguel, LocalDateTime dataHoraDevolucao, double desconto) {
        if (veiculoRepository.encontrarVeiculoPorPlaca(aluguel.getVeiculo().getPlaca()) == null) {
            throw new IllegalArgumentException("Veículo associado ao aluguel não existe.");
        }

        if (veiculoRepository.encontrarVeiculoPorPlaca(aluguel.getVeiculo().getPlaca()).isDisponivel()) {
            throw new IllegalArgumentException("Veículo não pode ser devolvido antes do aluguel.");
        }

        veiculoRepository.encontrarVeiculoPorPlaca(aluguel.getVeiculo().getPlaca()).liberar();

        Devolucao devolucao = new Devolucao(aluguel, dataHoraDevolucao, desconto);
        double valorAluguel = CalculoAluguelManager.calcularValorAluguel(aluguel.getVeiculo(), aluguel.getDataHoraInicio(), dataHoraDevolucao);
        devolucao.setValorTotal(valorAluguel - (valorAluguel * (desconto / 100))); // Aplicando desconto
        aluguel.setDevolucao(devolucao);

        return devolucao;
    }
}
