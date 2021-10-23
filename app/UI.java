package app;

import SGR.CadastroMoradores;
import SGR.CadastroDespesas;

import javax.swing.JOptionPane;

public class UI {

	static CadastroMoradores cadastroMoradores = new CadastroMoradores();

	public static void main(String[] args) {

		int opcao;

		do {
			String menu = "Informe a opcao desejada: \n" 
						+ "1 - Cadastrar morador \n" 
						+ "2 - Cadastrar despesa \n"
						+ "0 - Sair do programa";

			String strOpcao = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				cadastroMoradores.cadastrarMoradores();
				break;

			case 2:
				break;

			case 0:
				break;
			}

		} while (opcao != 0);

		// apenas um teste
		JOptionPane.showMessageDialog(null, "Rendimento total: " + cadastroMoradores.getRendimentoTota());

	}

}
