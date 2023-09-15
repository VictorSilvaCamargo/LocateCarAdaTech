package Aluguel;

import Aluguel.Aluguel;

import java.util.ArrayList;

public class AluguelRepository {
    private ArrayList<Aluguel> alugueis = new ArrayList<>();

    public void adicionarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public ArrayList<Aluguel> obterAlugueis() {
        return new ArrayList<>(alugueis);
    }

    public Aluguel encontrarAluguelPorPlaca(String placa) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getVeiculo().getPlaca().equals(placa)) {
                return aluguel;
            }
        }
        return null;
    }
}
