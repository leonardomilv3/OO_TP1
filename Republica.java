public class Republica {

    private ListaDeMoradores[] listaMoradores;
    private GrupoDeDespesas[] grupoDespesas;
    private int numDeVagas;
    private int numDeOcupantes;

    public Republica(ListaDeMoradores[] l, GrupoDeDespesas[] g,  int numDeVagas, int numDeOcupantes) {
        this.listaMoradores = l;
        this.grupoDespesas = g;
        this.numDeVagas = numDeVagas;
        this.numDeOcupantes = numDeOcupantes;
    }

    public void setNumDeVagas(int numDeVagas){
        this.numDeVagas = numDeVagas;
    }

    public int getNumDeVagas(){
        return numDeVagas;
    }

    public void setNumDeOcupantes(int numDeOcupantes){
        this.numDeOcupantes = numDeOcupantes;
    }

    public int getNumDeOcupantes(){
        return numDeOcupantes;
    }

    public void cadastrarMorador(Morador morador){
        
    }

    public void excluirMorador(Morador morador){

    }

    public void cadastrarDespesa(Despesa despesa){
        
    }
    
    public void excluirDespesa(Despesa despesa){

    }
}
