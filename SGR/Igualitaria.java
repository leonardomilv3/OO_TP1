package SGR;

public class Igualitaria extends Contribuicao{

    @Override
    public String calcularContribuicao(CadastroMoradores moradores, CadastroDespesas despesas){ 
        float valTotal = despesas.getValorTotal();
        int numMoradores = moradores.getNumeroMoradores();

        return "Cada um paga " + 100/numMoradores + "%" + " de " + valTotal;
    }
}
