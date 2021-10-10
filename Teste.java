import java.util.Arrays;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        int numeroDeMoradores;
        Scanner ler = new Scanner(System.in);
        String leitor;

        System.out.println("Quantos Moradores residem? ");
        numeroDeMoradores = ler.nextInt();
        if(numeroDeMoradores == 0){
            System.out.println("Não existe residentes");
        }else{
           Morador [] moradores = new Morador[numeroDeMoradores];

            for(int i = 0; i < moradores.length; i++){
                moradores[i] = new Morador();
                System.out.println("Digite o nome do morador: ");
                leitor = ler.next();
                moradores[i].setNome(leitor);

                System.out.println("Digite o email do morador: ");
                leitor = ler.next();
                moradores[i].setEmail(leitor);

                System.out.println("Digite o rendimento do morador: ");
                leitor = ler.next();
                moradores[i].setTotalDeRendimento(Float.parseFloat(leitor));
            }

            ListaDeMoradores l1 = new ListaDeMoradores();
            l1.setListaMoradores(moradores);

            System.out.println(Arrays.toString(l1.mostrarMoradores(moradores.length)));
            System.out.printf("%.2f %% %n",l1.calcularPorcentagemIgualitaria());
            System.out.println(l1.pesquisarMorador("Matheus"));
        }
    }
}
