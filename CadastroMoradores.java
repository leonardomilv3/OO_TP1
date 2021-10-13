public class CadastroMoradores  implements Impressora{
    private Morador [] moradores;

    @Override
    public void cadastrar(){
        
    }

    public float rendimentoTotal(){
        return 25.25f;  /// Valor aleatorio para tirar aviso de erro, nao esquecer de mudar
    }

    public float getRendimentoTota(){
        return 25.25f; /// Valor aleatorio para tirar aviso de erro, nao esquecer de mudar
    }

    @Override
    public boolean escreveTxt(String caminho) {
        return false;
    }
}
