package Calculo;

import Veiculo.Veiculo;

import java.time.LocalDateTime;

public class CalculoAluguelManager {
    public static double calcularValorAluguel(Veiculo veiculo, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        double valorDiaria = 0.0;

        if (veiculo.getTipo().equals("PEQUENO")) {
            valorDiaria = 100.0;
        } else if (veiculo.getTipo().equals("MEDIO")) {
            valorDiaria = 150.0;
        } else if (veiculo.getTipo().equals("SUV")) {
            valorDiaria = 200.0;
        } else {
            System.out.println("Tipo de veículo inválido.");
            return 0.0;
        }

        long dias = calcularDiferencaDias(dataHoraInicio, dataHoraFim);

        return valorDiaria * dias;
    }

    private static long calcularDiferencaDias(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        return java.time.temporal.ChronoUnit.DAYS.between(dataHoraInicio.toLocalDate(), dataHoraFim.toLocalDate());
    }
}
