package model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {
    private List<LinkedList<Departamento>> tabela;

    public TabelaEspalhamento() {
        tabela = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tabela.add(new LinkedList<>());
        }
    }

    public void inserirDepartamento(Departamento departamento) {
        int indice = funcaoHash(departamento.andar);
        LinkedList<Departamento> listaDepartamentos = tabela.get(indice);
        listaDepartamentos.add(departamento);
    }

    public Departamento consultarDepartamento(int andar, String nomeDepartamento) {
        int indice = funcaoHash(andar);
        LinkedList<Departamento> listaDepartamentos = tabela.get(indice);
        for (Departamento departamento : listaDepartamentos) {
            if (departamento.andar == andar && departamento.nome.equalsIgnoreCase(nomeDepartamento)) {
                return departamento;
            }
        }
        return null;
    }

    public boolean removerDepartamento(int andar, String nomeDepartamento) {
        int indice = funcaoHash(andar);
        LinkedList<Departamento> listaDepartamentos = tabela.get(indice);
        for (Departamento departamento : listaDepartamentos) {
            if (departamento.andar == andar && departamento.nome.equalsIgnoreCase(nomeDepartamento)) {
                listaDepartamentos.remove(departamento);
                return true;
            }
        }
        return false;
    }

    private int funcaoHash(int andar) {
        return andar % tabela.size();
    }
}