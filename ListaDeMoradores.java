import java.util.Objects;

public class ListaDeMoradores {
    private Morador[] listaMoradores;

    public float calcularPesos(){

        return 25.25f;
    }

    public double calcularPorcentagemIgualitaria(){
        double porcentagemPagar =  ((100/this.listaMoradores.length) * 0.01 );

        return porcentagemPagar * 100;
    }

    public String pesquisarMorador(String morador){
        for (Morador listaMoradore : this.listaMoradores) {
            if (Objects.equals(morador, listaMoradore.getNome())) {
                return listaMoradore.getNome() + " mora aqui";
            }
        }
        return "Nao Existe esse morador";
    }

    public String[] mostrarMoradores(int index) {
        String [] statusMoradores = new String[index];
        for (int i = 0; i < listaMoradores.length; i++){
            statusMoradores[i] = listaMoradores[i].getNome() + " " + listaMoradores[i].getEmail() + " " + listaMoradores[i].rendimento();
        }

        return statusMoradores;
    }
    
    public Morador[] getListaMoradores() {
        return this.listaMoradores;
    }
    
    public void setListaMoradores(Morador[] listaMoradores) {
        this.listaMoradores = listaMoradores;
    }
    
    public void escreveMoradoresEmArquivo(String caminho) {
    	
    	String arquivo = caminho;
    	String texto = null;
    	
    	for (int i = 0; i < listaMoradores.length; i++) {
			
			texto += listaMoradores[i].getNome() + ";" +
					 listaMoradores[i].getEmail() + ";" +
					 listaMoradores[i].rendimento() + "\r\n";
		}
    	
    	if(Arquivo.Escreve(arquivo, texto)) {
    		System.out.println("Lista de moradores salva em .txt");
    	}else {
    		System.out.println("Erro ao salvar lista de moradores em .txt");
    	}
    	
    }
}
