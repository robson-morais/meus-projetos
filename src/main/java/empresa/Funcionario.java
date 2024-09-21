package empresa;

import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private String departamento;
    private double salario;
    private int ID = 0;


    public int geradorID (){
        int num =(int) (Math.random()*10000);
        return num;
    }

    public Funcionario(String nome, String departamento, double salario){
        this.nome  = nome;
        this.departamento = departamento;
        this.salario = salario;
        this.ID = geradorID();
    }

    public static ArrayList<String> procurarNomesPorDepartamento(String departamento, ArrayList<Funcionario> funcionarios){
        ArrayList<String> nomes = new ArrayList<>();
        for (Funcionario depart: funcionarios){
            if (depart.getDepartamento().equals(departamento)){
                nomes.add(depart.getNome());
            }
        }
        return nomes;
    }

    public Funcionario(){
        this("","",0.0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "Nome: "+nome+"\nID: "+ID+"\nSalário: "+salario+"\nDepartamento: "+departamento+"\n";
    }
}