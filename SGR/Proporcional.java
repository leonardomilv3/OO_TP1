package SGR;

public class Proporcional extends Contribuicao{

    @Override
    public String calcularContribuicao(CadastroMoradores moradores, CadastroDespesas despesas){
        float k =  despesas.getValorTotal() / moradores.getRendimentoTotal();
        String resultado = "";

        for(int i = 0 ; i < moradores.getNumeroMoradores(); i++){
            Morador morador = moradores.getMoradores().get(i);
            resultado += morador.getNome() + " contribui " + "R$ " +  arredondar(k * morador.getRendimento()) + ", sendo  " + arredondar((morador.getRendimento()/moradores.getRendimentoTotal()) * 100) + "%" + " do total de despesas" + "\n";
        }

        return resultado;
    }
}
