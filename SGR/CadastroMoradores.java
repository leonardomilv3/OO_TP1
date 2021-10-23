package SGR;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroMoradores implements Impressora {

	private List<Morador> moradores;

	public CadastroMoradores() {
		// Usando o construtor para instanciar a lista encadeada
		// Foi a solucao que encontrei momentanemente
		moradores = new LinkedList<Morador>();
	}

	public void cadastrarMoradores() {

		String nome = JOptionPane.showInputDialog("Nome: ");
		String email = JOptionPane.showInputDialog("\n" + "Email: ");
		String strRendimento = JOptionPane.showInputDialog("\n" + "Rendimento: ");
		float rendimento = Float.parseFloat(strRendimento);

		// Instanciando Morador
		Morador morador = new Morador(nome, email, rendimento);

		moradores.add(morador); // adicionado o novo morador
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	private float rendimentoTotal() {
		
		float rendimentoTotal = 0;

		for (Morador m : moradores) {
			rendimentoTotal += m.getRendimento();
		}
		return rendimentoTotal;
	}

	public float getRendimentoTota() {
		return rendimentoTotal();
	}

	@Override
	public boolean escreveTxt(String caminho) {
		boolean escreveu = true;
		return escreveu;
	}

}