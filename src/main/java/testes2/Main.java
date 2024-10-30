package testes2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        PessoasList pessoasList = new PessoasList(pessoas);

        int opcao = 1;
        while (opcao!=3){
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1. Cadastrar pessoa;\n2. Pesquisar pessoa;\n3. Sair"));
            switch (opcao){
                case 1:
                    String nome = JOptionPane.showInputDialog("Nome: ");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
                    //pessoas.add(new Pessoa(nome,idade));
                    pessoasList.cadastrarpessoa(nome,idade);
                    break;
                case 2:
                    String search = JOptionPane.showInputDialog("Nome: ");
                    JOptionPane.showMessageDialog(null,pessoasList.pesquisarPessoasPorNome(search));
                    break;
            }
        }
        System.out.println(pessoasList.toString());
    }
}
