public class Teste {
    public static void main(String[] args) {
    	
    		Republica republica = new Republica();
    		
    		// Cadastro De Moradores
    		ListaDeMoradores l1 = new ListaDeMoradores();
    		l1.setListaMoradores(republica.cadastrarMoradores());
   		
    		// Cadastro De Despesas
    	    GrupoDeDespesas d1 = new GrupoDeDespesas();
    	    d1.setGrupoDeDespesas(republica.cadastrarDespesas());

            /*  Depois de instanciarem os moradores e as despesas, então repulica é instanciada

            *********************************
             Instanciar as depesas aqui
            *********************************

            para fins de exemplo, criei uma ref de GrupoDeDespesas = null
             */
            GrupoDeDespesas g1 = null;
                        
            System.out.printf("%.2f %% %n",l1.calcularPorcentagemIgualitaria());
            System.out.println(l1.pesquisarMorador("Matheus"));
            
        }
    }
