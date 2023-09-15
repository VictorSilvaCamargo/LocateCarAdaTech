package Devolucao;

import Devolucao.Devolucao;

import java.util.ArrayList;

public class DevolucaoRepository {
    private ArrayList<Devolucao> devolucoes = new ArrayList<>();

    public void adicionarDevolucao(Devolucao devolucao) {
        devolucoes.add(devolucao);
    }

    public ArrayList<Devolucao> obterDevolucoes() {
        return new ArrayList<>(devolucoes);
    }
}
