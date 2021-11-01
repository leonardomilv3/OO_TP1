package SGR;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import Exceptions.CategoriaNaoInformadaException;
import Exceptions.DataInvalidoException;
import Exceptions.DescricaoNaoInformadaException;
import Exceptions.ValorNaoInformadoException;
import Exceptions.ValorNegativoException;

public class CadastroDespesas implements Impressora {

	private List<Despesa> despesas;
	protected int mes;
	protected String strAno;
	protected String nomeArquivo = null;

	public CadastroDespesas() {
		// Usando o construtor para instanciar a lista encadeada
		// Foi a solucao que encontrei momentanemente
		despesas = new LinkedList<Despesa>();
	}

	public void cadastrarDespesas() {
		Boolean repetir = false;
		String descricao = null;
		String categoria = null;
		String strValor = null;
		String strMes = null;
		float valor = 0;

		do {
			repetir = false;

			try {
				strMes = JOptionPane.showInputDialog("Mes: " + "\n");

				if (strMes.isEmpty()) {
					throw new DataInvalidoException();
				} else {
					mes = Integer.parseInt(strMes);
				}
				
				if (mes < 0 || mes > 12) {
					throw new DataInvalidoException();					
				}
				
				strAno = JOptionPane.showInputDialog("Ano: " + "\n");
				
				if (strAno.isEmpty()) {
					throw new DataInvalidoException();
				}

			} catch (DataInvalidoException e) {
				repetir = true;

				String msg = "ERRO! Data inválida \n";

				JOptionPane.showMessageDialog(null, msg);
				e.printStackTrace();

			}
		} while (repetir);
		

		do {
			repetir = false;

			try {
				descricao = JOptionPane.showInputDialog("Descricao: " + "\n");

				if (descricao.isEmpty()) {
					throw new DescricaoNaoInformadaException();
				}

			} catch (DescricaoNaoInformadaException e) {
				repetir = true;

				String msg = "ERRO! Descrição da despesa não informada \n";

				JOptionPane.showMessageDialog(null, msg);
				e.printStackTrace();

			}
		} while (repetir);

		do {
			repetir = false;

			try {
				categoria = JOptionPane.showInputDialog("Categoria: " + "\n");

				if (categoria.isEmpty()) {
					throw new CategoriaNaoInformadaException();
				}

			} catch (CategoriaNaoInformadaException e) {
				repetir = true;

				String msg = "ERRO! Categoria da despesa não informada \n";

				JOptionPane.showMessageDialog(null, msg);
				e.printStackTrace();
			}

		} while (repetir);

		do {
			repetir = false;

			try {
				strValor = JOptionPane.showInputDialog("Valor: " + "\n");

				if (strValor.isEmpty()) {
					throw new ValorNaoInformadoException();
				} else {
					valor = Float.parseFloat(strValor);
				}

				if (valor < 0) {
					throw new ValorNegativoException();
				}

			} catch (ValorNaoInformadoException e) {
				repetir = true;

				String msg = "ERRO! Valor da despesa não informado \n";

				JOptionPane.showMessageDialog(null, msg);
				e.printStackTrace();

			} catch (ValorNegativoException e) {
				repetir = true;

				String msg = "ERRO! Valor da despesa negativo \n";

				JOptionPane.showMessageDialog(null, msg);
				e.printStackTrace();
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
	
	//Solução inicial para escrever despesas
	public void escreveDespesas(){

		String auxMes = null;
		if(this.mes == 1 ){
			auxMes = "Jan";
		}
		else if (this.mes == 2 ) {
			auxMes = "Fev";
		}
		else if (this.mes == 3 ) {
			auxMes = "Mar";
		}
		else if (this.mes == 4 ) {
			auxMes = "Abr";
		}
		else if (this.mes == 5 ) {
			auxMes = "Mai";
		}
		else if (this.mes == 6 ) {
			auxMes = "Jun";
		}
		else if (this.mes == 7 ) {
			auxMes = "Jul";
		}
		else if (this.mes == 8) {
			auxMes = "Ago";
		}
		else if (this.mes == 9 ) {
			auxMes = "Set";
		}
		else if (this.mes == 10) {
			auxMes = "Out";
		}
		else if (this.mes == 11) {
			auxMes = "Nov";
		}
		else if (this.mes == 12) {
			auxMes = "Dez";
		}


		String fileName = "despesas_"+auxMes+"_"+this.strAno+".txt";


		BufferedWriter buffer = null;
		FileWriter out = null;
		try {
			out = new FileWriter(fileName);
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

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getAno() {
		return strAno;
	}

	public void setAno(String ano) {
		this.strAno = ano;
	}

	@Override
	public boolean escreveTxt(String caminho) {
		boolean escreveu = true;
		return escreveu;
	}

}
