package SGR;

public class CadastroDespesas implements Impressora {

    static Despesa[] despesas = new Despesa[0];

    public void cadastrarDespesas() {
    }

    public Despesa[] getDespesas() {
        return despesas;
    }

    private float valorTotal() {
        float valorTotal = 0;
        return valorTotal; 
    }

    public float getValorTotal() {
        return valorTotal();
    }

    @Override
    public boolean escreveTxt(String caminho) {
        boolean escreveu = true;
        return escreveu;
    }

}