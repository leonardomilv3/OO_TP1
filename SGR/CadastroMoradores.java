package SGR;

public class CadastroMoradores implements Impressora {

    static Morador[] moradores = new Morador[0];

    public void cadastrarMoradores() {
    }

    public Morador[] getMoradores() {
        return moradores;
    }

    private float rendimentoTotal() {
        float rendimentoTotal = 0;
        return rendimentoTotal;
    }

    public float getRendimentoTota() {
        return rendimentoTotal();
    }

    @Override
    public boolean escreveTxt(String caminho) {
        boolean escreveu = true;
        return escreveu;
    }

}