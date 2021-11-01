package SGR;

import Exceptions.CadastrarSubcategoriaAntesDeCadastrarPeloMenosUmaCategoriaException;
import Exceptions.CategoriaNaoInformadaException;
import Exceptions.DataInvalidoException;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class CadastroDespesas {

    List<CategoriaDespesa> listaCategoriasDespesas;
    List<SubCategoriaDespesa> listaSubCategoriasDespesas;
    List<Despesa> listaDespesas;
    int month;
    int year;

    public CadastroDespesas() {
        listaCategoriasDespesas = new LinkedList<CategoriaDespesa>();
        listaSubCategoriasDespesas = new LinkedList<SubCategoriaDespesa>();
        listaDespesas = new LinkedList<Despesa>();
    }

    public void cadastrarCategoria() {
        Boolean repetir = false;

        do {
            repetir = false;

            try {
                String descricaoCategoria = JOptionPane.showInputDialog("Informe uma descricao para categoria:");

                if (descricaoCategoria.isEmpty()) {
                    throw new CategoriaNaoInformadaException();
                } else {
                    CategoriaDespesa a = new CategoriaDespesa(descricaoCategoria);
                    boolean respostaA = listaCategoriasDespesas.add(a);
                    if (respostaA) {
                        JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
                    }

                }

            } catch (CategoriaNaoInformadaException e) {
                repetir = true;

                String msg = "ERRO! Usuario nao informou uma descricao para categoria: \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();

            }
        } while (repetir);


        System.out.println("Terminou cadastrarCategoria: listaCategoriasDespesas => " + listaCategoriasDespesas);
        return;

    }

    public void cadastrarSubcategoria() {

        Boolean repetir = false;

        do {
            repetir = false;

            try {
                if (listaCategoriasDespesas.isEmpty()) {
                    throw new CadastrarSubcategoriaAntesDeCadastrarPeloMenosUmaCategoriaException();


                } else {
                    Object n = (Object)JOptionPane.showInputDialog(null, "Cadastrar uma subcategoria da categoria:","Cadastrar subcategoria", JOptionPane.QUESTION_MESSAGE, null, listaCategoriasDespesas.toArray(), listaCategoriasDespesas.get(0));

                    String descricaoSubCategoria = JOptionPane.showInputDialog("Você está cadastrando uma subcategoria da categoria: " + n + ". \n" + "Agora informe o nome da subcategoria:");

                    int objectIndex = listaCategoriasDespesas.indexOf(n);

                    SubCategoriaDespesa b = new SubCategoriaDespesa(listaCategoriasDespesas.get(objectIndex), descricaoSubCategoria);

                    boolean respostaB = listaSubCategoriasDespesas.add(b);

                    if (respostaB) {
                        JOptionPane.showMessageDialog(null, "Subcategoria cadastrada com sucesso!");
                    }

                }

            } catch (CadastrarSubcategoriaAntesDeCadastrarPeloMenosUmaCategoriaException e) {

                String msg = "ERRO! Antes de cadastrar uma subcategoria, voce precisa cadastrar pelo menos uma categoria. \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();

            }

        } while (repetir);


        System.out.println("Terminou cadastrarSubcategoria: listaSubCategoriasDespesas => " + listaSubCategoriasDespesas);
        return;

    }

    
    //TO-DO cadastrarDespesa
    public void cadastrarDespesa() {

        Boolean repetir = false;



        do {
            repetir = false;

            String[] meses = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };


            try {
                String mes_Str = (String)JOptionPane.showInputDialog(null, "Escolha o mes referente a despesa","Cadastrar Despesa", JOptionPane.QUESTION_MESSAGE, null, meses, meses[0]);

                int mes_Int;

                if (mes_Str.isEmpty()) {
                    throw new DataInvalidoException();
                } else {
                    mes_Int = Integer.parseInt(mes_Str);
                }

                if (mes_Int < 0 || mes_Int > 12) {
                    throw new DataInvalidoException();
                }

                String ano_Str = JOptionPane.showInputDialog("Informe o ano da Despesa. \nExemplo: 2021 \n");

                if (ano_Str.isEmpty()) {
                    throw new DataInvalidoException();
                }

                System.out.println("Mes:" + mes_Str + " Ano: " +  ano_Str);


            } catch (DataInvalidoException e) {
                repetir = true;

                String msg = "ERRO! Data invalida \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();

            }
        } while (repetir);


        do {
            repetir = false;

            List<String> listaCategoriaESubcategorias = new LinkedList<String>();

            for (int i = 0; i < listaCategoriasDespesas.size(); i++) {

                String categoria = listaCategoriasDespesas.get(i).toString();

                listaCategoriaESubcategorias.add(categoria);

            }

            for (int i = 0; i < listaSubCategoriasDespesas.size(); i++) {

                String Subcategoria = listaSubCategoriasDespesas.get(i).toString();

                listaCategoriaESubcategorias.add(Subcategoria);

            }



            String testeCategoria = (String)JOptionPane.showInputDialog(null, "Escolha a categoria ou subcategoria referente a despesa","Cadastrar Despesa", JOptionPane.QUESTION_MESSAGE, null, listaCategoriaESubcategorias.toArray(), listaCategoriaESubcategorias.get(0));

            System.out.println("testeCategoria => " + testeCategoria);


        } while (repetir);




        return;

    }








}
