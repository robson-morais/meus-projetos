package empresa;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Empresa {
    public static void main(String[] args) {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        boolean sair = false;

        while (!sair){
            int menu = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\n1. Cadastrar Funcionário\n2. Consutar lista de funcionários\n3. Atualizar salário de um funcionário\n4. Pesquisar funcionário por departamento\n5. Sair"));
             switch (menu){
                 case 1:
                     String nome = JOptionPane.showInputDialog(null,"Nome: ");
                     String departamento = JOptionPane.showInputDialog(null,"Departamento: ");
                     double salario = Double.parseDouble(JOptionPane.showInputDialog(null,"Salário atual: "));
                     Funcionario f = new Funcionario(nome, departamento, salario);
                     funcionarios.add(f);
                     break;
                 case 2:
                     for(Funcionario i: funcionarios){
                         JOptionPane.showMessageDialog(null, funcionarios.toString()+"\n");
                         break;
                     } break;
                 case 3:
                     String setNome = JOptionPane.showInputDialog(null,"Nome do funcionário: ");
                     double newSalario = Double.parseDouble(JOptionPane.showInputDialog(null,"Novo salário: "));
                     for (Funcionario s: funcionarios){
                         if (s.getNome().equals(setNome)){
                             s.setSalario(newSalario);
                             break;
                         }
                     }
                     JOptionPane.showMessageDialog(null,"O salario de "+setNome+" foi atualizado para R$ "+newSalario);
                     break;
                 case 4:
                     String departamentoSearch = JOptionPane.showInputDialog(null,"Qual o departamento: ");
                     JOptionPane.showMessageDialog(null, "Lista de funcionários deste departamento: \n"+ Funcionario.procurarNomesPorDepartamento(departamentoSearch, funcionarios));
                     break;
                 case 5:
                     sair = true;
             }
        }
    }
}