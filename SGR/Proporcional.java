package SGR;

public class Proporcional extends Contribuicao{

    @Override
    public String calcularContribuicao(CadastroMoradores moradores, CadastroDespesas despesas){
        float k = moradores.getRendimentoTotal() / despesas.getValorTotal(); // constante de proporcionalidade
        String resultado = "";

        for(int i = 0 ; i < moradores.getNumeroMoradores(); i++){
            //resultado += moradores.     Quero fazer um loop em que va adicionando "<nome_morador> pagará X (que será k * rendimento desse morador)
        }

        return resultado;
    }
}


