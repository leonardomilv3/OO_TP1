package app;

import SGR.CadastroMoradores;
import SGR.CadastroDespesas;

import javax.swing.JOptionPane;

public class UI {

	static CadastroMoradores cadastroMoradores = new CadastroMoradores();
	static CadastroDespesas cadastroDespesas = new CadastroDespesas();
	public static void main(String[] args) {

        ApresentarMenu();
		// apenas um teste
		JOptionPane.showMessageDialog(null, "Rendimento total: " + cadastroMoradores.getRendimentoTota());
    }

    private static int escolhaOpcao(){
		int opcao;
		String menu = "Sistema de Gerenciamento de República \n"
					+ "1 - Cadastrar Morador\n"
					+ "2 - Cadastrar Despesa\n"
					+ "3 - Cadastrar Categoria\n"
					+ "0 - Sair do programa";
		String Stropcao = JOptionPane.showInputDialog(menu);
		opcao = Integer.parseInt(Stropcao);
		return opcao;
	}

    private static void ApresentarMenu(){ 
        int opcao = 0;
		do { 
			//1a coisa: definir qual figura vai ser criada
			opcao = escolhaOpcao();
			switch (opcao) {
			case 1:
				cadastroMoradores.cadastrarMoradores();
				break;
			case 2: 
 				cadastroDespesas.cadastrarDespesas();
				break;
			case 3: 
                
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

}
