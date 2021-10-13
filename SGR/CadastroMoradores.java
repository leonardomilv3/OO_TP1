package SGR;

public class CadastroMoradores  implements Impressora {
    
    static Morador[] moradores = new Morador[0];
    
    public void cadastrarMoradores(Morador[] moradores){

    }

    public Morador[] getMoradores(){
        return moradores;
    }

    private float rendimentoTotal(){
        return 25.25f;  /// Valor aleatorio para tirar aviso de erro, nao esquecer de mudar
    }

    public float getRendimentoTota(){
        return rendimentoTotal(); 
    }

    @Override
    public boolean escreveTxt(String caminho) {
        return false;
    }

}
