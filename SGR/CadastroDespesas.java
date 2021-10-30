package SGR;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import Exceptions.CategoriaNaoInformadaException;
import Exceptions.DescricaoNaoInformadaException;
import Exceptions.ValorNaoInformadoException;


public class CadastroDespesas implements Impressora {

	private List<Despesa> despesas;
	protected String mes;
	protected String ano;
	protected String nomeArquivo = null;

	public CadastroDespesas() {
		// Usando o construtor para instanciar a lista encadeada
		// Foi a solucao que encontrei momentanemente
		despesas = new LinkedList<Despesa>();
	}

	public void cadastrarDespesas() {
		String descricao = null;
		String categoria = null;
		String strValor = null;
		float valor = 0;
		
			try {
				mes = JOptionPane.showInputDialog("Mes: " + "\n");
				ano = JOptionPane.showInputDialog("Ano: " + "\n");
				descricao = JOptionPane.showInputDialog("Descricao: " + "\n");
				strValor = JOptionPane.showInputDialog("Valor: " + "\n");
				categoria = JOptionPane.showInputDialog("Categoria: " + "\n");

				nomeArquivo = "despesas" + "_" + mes + "_" + ano + ".txt";

				if (strValor.isEmpty()) {
					throw new ValorNaoInformadoException();
				} else {
					valor = Float.parseFloat(strValor);
				}

				if (descricao.isEmpty()) {
					throw new DescricaoNaoInformadaException();
				}

				if (categoria.isEmpty()) {
					throw new CategoriaNaoInformadaException();
				}

			} catch (CategoriaNaoInformadaException e) {
				String msg = "ERRO! Categoria da despesa não informada \n";

				JOptionPane.showMessageDialog(null, msg);
				e.printStackTrace();

				do {
					descricao = JOptionPane.showInputDialog("Categoria: " + "\n");

					if (descricao.isEmpty()) {
						JOptionPane.showMessageDialog(null, msg);
						e.printStackTrace();
					}
				} while (categoria.isEmpty());

			} catch (DescricaoNaoInformadaException e) {
				
				String msg = "ERRO! Descrição da despesa não informada \n";

				JOptionPane.showMessageDialog(null, msg);
				e.printStackTrace();

				do {
					descricao = JOptionPane.showInputDialog("Descricao: " + "\n");

					if (descricao.isEmpty()) {
						JOptionPane.showMessageDialog(null, msg);
						e.printStackTrace();
					}
				} while (descricao.isEmpty());

				
			} catch (ValorNaoInformadoException e) {
				
				String msg = "ERRO! Valor da despesa não informado \n";
				
				JOptionPane.showMessageDialog(null, msg);
				e.printStackTrace();

				do {
					strValor = JOptionPane.showInputDialog("Valor: " + "\n");

					if (strValor.isEmpty()) {
						JOptionPane.showMessageDialog(null, msg);
						e.printStackTrace();

					} else {
						valor = Float.parseFloat(strValor);
					}

				} while (strValor.isEmpty());
			}

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