package SGR;

public class Proporcional extends Contribuicao{
    static CadastroMoradores cadastroMoradores = new CadastroMoradores();
    static CadastroDespesas cadastroDespesas = new CadastroDespesas();

    @Override
    public String calcularContribuicao(CadastroMoradores moradores, CadastroDespesas despesas){
        float k = moradores.getRendimentoTotal() / despesas.getValorTotal();
        String resultado = "";



        for(int i = 0 ; i < moradores.getNumeroMoradores(); i++){
            Morador morador = moradores.getMoradores().get(i);
            resultado += morador.getNome() + " pagará " + "R$ " + k * morador.getRendimento() + "\n";
        }

        return resultado;
    }

}
