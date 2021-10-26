package SGR;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import Exceptions.DadosPessoaisIncompletosException;
import Exceptions.RendimentoInvalidoException;

public class CadastroDespesas implements Impressora {

	private List<Despesa> despesas;
	protected String mes;
	protected String ano;
	String nomeArquivo = null;

	public CadastroDespesas() {
		// Usando o construtor para instanciar a lista encadeada
		// Foi a solucao que encontrei momentanemente
		despesas = new LinkedList<Despesa>();
	}

	public void cadastrarDespesas() {
		boolean repetir = false;
		String descricao = null, categoria = null, strValor;
		float valor = 0;
		do {
			try {
				mes = JOptionPane.showInputDialog("Mes: ");
				ano = JOptionPane.showInputDialog("Ano: ");
				descricao = JOptionPane.showInputDialog("Descricao: ");
				strValor = JOptionPane.showInputDialog("\n" + "Valor: ");
				categoria = JOptionPane.showInputDialog("\n" + "Categoria: ");

				nomeArquivo = "despesas" + "_" + mes + "_" + ano + ".txt";

				if (!strValor.isEmpty()) {
					valor = Float.parseFloat(strValor);
				}

				if (descricao.isEmpty() || categoria.isEmpty() || strValor.isEmpty()) {
					throw new DadosPessoaisIncompletosException();
				} else if (valor < 0) {
					throw new RendimentoInvalidoException();
				}

			} catch (DadosPessoaisIncompletosException e) {
				repetir = true;
				JOptionPane.showMessageDialog(null, "ERRO! Por favor preencha todos os campos");
			} catch (RendimentoInvalidoException e) {
				do {
					JOptionPane.showMessageDialog(null, "ERRO! Não é possível um rendimento negativo ou vazio!");
					strValor = JOptionPane.showInputDialog("\n" + "Valor: ");
					if (!strValor.isEmpty()) {
						valor = Float.parseFloat(strValor);
					}
				} while (valor < 0 || strValor.isEmpty());
				repetir = false;
			}
		} while (repetir);

		// Instanciando Morador
		Despesa despesa = new Despesa(descricao, valor, categoria);

		despesas.add(despesa); // adicionado o nova despesa
	}

	private float valorTotal() {
		float valorTotal = 0;

		for (Despesa m : despesas) {
			valorTotal += m.getValorDespesa();
		}

		return valorTotal;
	}

	// Gravando despesas em arquivo "despesas.txt"
	public void escreveDespesas() {

		BufferedWriter buffer = null;
		FileWriter out = null;

		try {
			out = new FileWriter(nomeArquivo);
			buffer = new BufferedWriter(out);

			for (Despesa a : despesas) {
				buffer.write(a.getDescricao().toString());
				buffer.write(';');
				buffer.write(a.getCategoria().toString());
				buffer.write(';');
				String r = Float.toString(a.getValorDespesa());
				buffer.write(r.toString());
				buffer.write('\n');
			}

			buffer.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public float getValorTotal() {
		return valorTotal();
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public boolean escreveTxt(String caminho) {
		boolean escreveu = true;
		return escreveu;
	}

}