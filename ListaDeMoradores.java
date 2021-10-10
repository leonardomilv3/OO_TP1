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
        return "Não Existe esse morador";
    }

    public String[] mostrarMoradores(int index) {
        String [] statusMoradores = new String[index];
        for (int i = 0; i < listaMoradores.length; i++){
            statusMoradores[i] = listaMoradores[i].getNome() + " " + listaMoradores[i].getEmail() + " " + listaMoradores[i].getTotalDeRendimento();
        }

        return statusMoradores;
    }
    
    public void setListaMoradores(Morador[] listaMoradores) {
        this.listaMoradores = listaMoradores;
        
    }
}
