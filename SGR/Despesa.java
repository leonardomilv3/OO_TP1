package SGR;

public class Despesa {
	
	protected String descricao;
    protected float valorDespesa;
    protected String categoria;
    
    public Despesa(String descricao, float valorDespesa, String categoria) {
		this.descricao = descricao;
		this.valorDespesa = valorDespesa;
		this.categoria = categoria;
	}
  
    public String getDescricao() {
        return descricao;
    }

    public float getValorDespesa() {
        return valorDespesa;
    }

    public String getCategoria() {
        return categoria;
    }
}
