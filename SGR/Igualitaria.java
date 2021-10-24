package SGR;

public class Igualitaria extends Contribuicao{

    @Override
    public String calcularContribuicao(float valorTotalDespesa, int numeroMoradores){ // os argumentos devem passar os metodos que retornem os valores desejados
        float valTotal = valorTotalDespesa;
        int numMoradores = numeroMoradores;

        return "Cada um paga " + 100/numMoradores + "%" + " de " + valTotal;
    }
}
