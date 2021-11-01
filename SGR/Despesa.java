package SGR;

public class Despesa {
	
    private String descricao;
    private String categoria;
    private Float valorDespesa;
    
    public Despesa(String descricao, String categoria, Float valorDespesa) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorDespesa = valorDespesa;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valorDespesa=" + valorDespesa +
                '}';
    }
  
    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public Float getValorDespesa() {
        return valorDespesa;
    }
}

