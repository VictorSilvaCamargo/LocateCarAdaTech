package Devolucao;
import Aluguel.*;
import Pessoa.*;
import java.time.LocalDateTime;
import java.time.Duration;

public class Devolucao {
    private Aluguel aluguel;
    private LocalDateTime dataHoraDevolucao;
    private double desconto;
    private double valorTotal;

    public Devolucao(Aluguel aluguel, LocalDateTime dataHoraDevolucao, double desconto) {
        this.aluguel = aluguel;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.desconto = desconto;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public LocalDateTime getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(LocalDateTime dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
