package SGR;

public abstract class Contribuicao {
	static CadastroMoradores cadastroMoradores = new CadastroMoradores();
	static CadastroDespesas cadastroDespesas = new CadastroDespesas();

	public abstract String calcularContribuicao(float valorTotal, int numeroMoradores);
	
}
