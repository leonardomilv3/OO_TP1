package SGR;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CadastroMoradores implements Impressora {

	private List<Morador> moradores;
	String nomeArquivo = "alunos.txt";

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
	
	public int getNumeroMoradores(){
        	return  this.moradores.size();
    	}
	
	//Gravando moradores em arquivo "alunos.txt"
	public void escreveAlunos(){
		
		BufferedWriter buffer = null;
        	FileWriter out = null;
		
		try {
           		out = new FileWriter(nomeArquivo);
            		buffer = new BufferedWriter(out);

            		for (Morador a : moradores) {
                		buffer.write(a.getNome().toString());
				buffer.write(';');
				buffer.write(a.getEmail().toString());
				buffer.write(';');
				String r = Float.toString(a.getRendimento());
				buffer.write(r.toString());
				buffer.write('\n');
        		}
			
			buffer.close();
       		} catch (IOException e) {
           		// TODO: handle exception
        	}	
		
	}

}
