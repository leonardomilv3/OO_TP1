import javax.swing.JOptionPane;

public class Republica {
	
	static Morador[] moradores = new Morador[0];
	static Despesa[] despesas = new Despesa[0];

    public Morador[] cadastrarMoradores(){
    	
    }

    public Despesa[] cadastrarDespesas(){
    	
    	String mes = JOptionPane.showInputDialog("Mes: ");
		String ano = JOptionPane.showInputDialog("\n" + "Ano: ");
		
    	int opcao;

		do{
			String strOpcao = JOptionPane.showInputDialog("Adicionar despesa?" + "\n" 
														+ "1 - Sim" + "\n" 
														+ "0 - Não" + "\n");
			
			opcao = Integer.parseInt(strOpcao);
			
			if(opcao == 1) {
				
				String descricao = JOptionPane.showInputDialog("Descricao: ");
				String strValor = JOptionPane.showInputDialog("\n" + "Valor: ");
				float valor = Float.parseFloat(strValor);
				
				//Criando Despesa
				Despesa despesa = new Despesa(descricao, valor);
	
				// inserir c dentro do vetor contatos.
				// Esforco bracal!
	
				Despesa[] temp = new Despesa[despesas.length + 1];
	
				for (int i = 0; i < despesas.length; i++) {
	
					temp[i] = despesas[i];
	
				}
				// inserir despesa em temp
				temp[despesas.length] = despesa;
	
				// atualizar referencia de despesas
				despesas = temp;
			}
			
		}while (opcao != 0); 
		
		/*
        d1.setMes(mes);
        d1.setAno(ano);
        */
         
		return despesas;
    	
    }
    
    public void excluirMorador(String nome){

    }

    
    public void excluirDespesa(Despesa despesa){

    }
}
