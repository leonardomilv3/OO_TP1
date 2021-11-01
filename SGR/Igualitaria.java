package SGR;

public class Igualitaria extends Contribuicao{

    @Override
    public String calcularContribuicao(CadastroMoradores moradores, CadastroDespesas despesas){ 
        float valTotal = despesas.getValorTotal();
        float numMoradores = moradores.getNumeroMoradores();

        return "Cada um paga " + arredondar(100/numMoradores) + "%" + " de " + valTotal;
    }
}
