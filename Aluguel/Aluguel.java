package Aluguel;

import Devolucao.Devolucao;
import Pessoa.Pessoa;
import Veiculo.Veiculo;

import java.time.LocalDateTime;

public class Aluguel {
    private Pessoa cliente;
    private Veiculo veiculo;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String local;
    private Devolucao devolucao;

    public Aluguel(Veiculo veiculo, Pessoa cliente, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }
}
