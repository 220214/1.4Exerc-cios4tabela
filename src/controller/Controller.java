package controller;
import javax.swing.JOptionPane;

import model.Departamento;
import model.TabelaEspalhamento;

public class Controller {
    private TabelaEspalhamento tabela;

    public Controller() {
        tabela = new TabelaEspalhamento();
        inicializarDepartamentos();
    }

    public void inicializarDepartamentos() {
        tabela.inserirDepartamento(new Departamento(0, "celulares e smartphones", "Artigos para telefonia móvel"));
        tabela.inserirDepartamento(new Departamento(0, "tv e vídeo", "Artigos para televisores"));
        tabela.inserirDepartamento(new Departamento(0, "consoles e games", "Artigos para video games"));
        tabela.inserirDepartamento(new Departamento(0, "áudio", "Artigos de som"));
        tabela.inserirDepartamento(new Departamento(0, "telefonia fixa", "Artigos para telefonia"));
        tabela.inserirDepartamento(new Departamento(0, "informática", "Computadores e laptops corporativos"));
        tabela.inserirDepartamento(new Departamento(0, "acessórios e periféricos", "Hardwares"));
        tabela.inserirDepartamento(new Departamento(0, "pc gamer", "Computadores e laptops gamers"));
        tabela.inserirDepartamento(new Departamento(1, "eletrodomésticos", "Artigos Eletrodomésticos"));
        tabela.inserirDepartamento(new Departamento(1, "eletroportáteis", "Artigos Eletroportáteis"));
        tabela.inserirDepartamento(new Departamento(1, "ar e ventilação", "Ventiladores e Ar condicionado"));
        tabela.inserirDepartamento(new Departamento(1, "móveis e decoração", "Móveis"));
        tabela.inserirDepartamento(new Departamento(1, "casa e construção", "Materiais para construção"));
        tabela.inserirDepartamento(new Departamento(1, "cama, mesa e banho", "Artigos para cama, mesa e banho"));
        tabela.inserirDepartamento(new Departamento(2, "livros", "Livraria"));
        tabela.inserirDepartamento(new Departamento(2, "instrumentos musicais", "Instrumentos músicas e acessórios"));
        tabela.inserirDepartamento(new Departamento(2, "música", "Discos"));
        tabela.inserirDepartamento(new Departamento(2, "filmes e séries", "DVD e Blu-ray"));
        tabela.inserirDepartamento(new Departamento(3, "mercado", "Itens de supermercado"));
        tabela.inserirDepartamento(new Departamento(3, "automotivo", "Peças e acessórios para automóveis"));
        tabela.inserirDepartamento(new Departamento(3, "brinquedos", "Itens infantis"));
        tabela.inserirDepartamento(new Departamento(3, "bebês", "Itens para a primeira infância"));
        tabela.inserirDepartamento(new Departamento(3, "gift cards", "Cartões presente"));
        tabela.inserirDepartamento(new Departamento(3, "pet shop", "Comida e acessórios para pet"));
        tabela.inserirDepartamento(new Departamento(3, "papelaria", "Itens de papelaria"));
    }

    public void consultarDepartamento() {
        int andar = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do andar:"));
        String nomeDepartamento = JOptionPane.showInputDialog("Digite o nome do departamento:");
        Departamento departamento = tabela.consultarDepartamento(andar, nomeDepartamento);
        if (departamento != null) {
            JOptionPane.showMessageDialog(null, "Departamento encontrado:\nAndar: " + departamento.andar +
                    "\nNome: " + departamento.nome + "\nDescrição: " + departamento.descricao);
        } else {
            JOptionPane.showMessageDialog(null, "Departamento não encontrado.");
        }
    }

    public void removerDepartamento() {
        int andar = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do andar:"));
        String nomeDepartamento = JOptionPane.showInputDialog("Digite o nome do departamento:");
        boolean removido = tabela.removerDepartamento(andar, nomeDepartamento);
        if (removido) {
            JOptionPane.showMessageDialog(null, "Departamento removido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Departamento não encontrado.");
        }
    }
    public static void main(String[] args) {
        Controller controller = new Controller();
        String opcao = JOptionPane.showInputDialog("Selecione uma opção:\n1. Consultar departamento\n2. Remover departamento");
        if (opcao.equals("1")) {
            controller.consultarDepartamento();
        } else if (opcao.equals("2")) {
            controller.removerDepartamento();
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }
}