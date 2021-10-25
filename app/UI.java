package app;

import SGR.CadastroMoradores;
import SGR.CadastroDespesas;
import SGR.Igualitaria;

import javax.swing.JOptionPane;

public class UI {

	static CadastroMoradores cadastroMoradores = new CadastroMoradores();
	static CadastroDespesas cadastroDespesas = new CadastroDespesas();
	static Igualitaria contIgual = new Igualitaria();

	public static void main(String[] args) {

        ApresentarMenu();

    }

    private static int escolhaOpcao(){
		int opcao;
		String menu = "Sistema de Gerenciamento de República \n"
					+ "1 - Cadastrar Morador\n"
					+ "2 - Cadastrar Categoria\n"
					+ "3 - Cadastrar Subcategoria\n"
					+ "4 - Cadastrar Despesa\n"
					+ "5 - Cálculo da Contribuição\n"
					+ "0 - Sair do programa";
		String Stropcao = JOptionPane.showInputDialog(menu);
		opcao = Integer.parseInt(Stropcao);
		return opcao;
	}

    private static void ApresentarMenu(){ 
        int opcao = 0;
		do { 
			opcao = escolhaOpcao();
			switch (opcao) {
			case 1:
				cadastroMoradores.cadastrarMoradores();
				cadastroMoradores.escreveAlunos(); //Adicionando novo morador ao arquivo "aluno.txt"
				break;
			case 2: 
 				// cadastroDespesas.cadastrarCategoria();
				break;
			case 3: 
                //  cadastroDespesas.cadastrarSubcategoria();
				break;
			case 4:
				cadastroDespesas.cadastrarDespesas();
				break;
			case 5:
				ApresentarMenuContribuicao();
				break;
			case 0: 
				JOptionPane.showMessageDialog(null, " Obrigado por utilizar o programa! Volte Sempre!");
				break;
			default:
				JOptionPane.showMessageDialog(null, " Opção Inválida!!");
				break;
			}
		} while (opcao != 0);
    }

	private static int escolhaOpcaoContribuicao() {
		int opcao;
		String menu = "------Contribuição------\n"
					+ "1 - Contribuição Igualitária \n"
					+ "2 - Contribuição Proporcional\n"
					+ "0 - Sair";
		String Stropcao = JOptionPane.showInputDialog(menu);
		opcao = Integer.parseInt(Stropcao);
		return opcao;
	}

	private static void ApresentarMenuContribuicao(){ 
        int opcao = 0;
		do { 
			opcao = escolhaOpcaoContribuicao();
			switch (opcao) {
			case 1:
				JOptionPane.showMessageDialog(null, "Rendimento total: " + cadastroMoradores.getRendimentoTotal());
				JOptionPane.showMessageDialog(null,  contIgual.calcularContribuicao(cadastroMoradores, cadastroDespesas)); // Teste do metodo calcular contribuicao ** 
				break;
			case 2: 
 				// cadastroDespesas.cadastrarCategoria();
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, " Opção Inválida!!");
				break;
			}
		} while (opcao !=0);
    }

}
