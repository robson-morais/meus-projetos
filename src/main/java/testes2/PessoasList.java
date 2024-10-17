package testes2;

import java.util.ArrayList;
import java.util.List;

public class PessoasList implements PessoasInterface{
    private List<Pessoa> pessoas;

    public PessoasList(List<Pessoa> pessoas){
        this.pessoas = pessoas;
    }

    public PessoasList(){
        this(new ArrayList<Pessoa>());
    }

    @Override
    public void cadastrarpessoa(String nome, int idade) {
        this.pessoas.add(new Pessoa(nome, idade));
    }

    @Override
    public List<Pessoa> pesquisarPessoasPorNome(String nome) {
        List<Pessoa> pessoasEncontradas = new ArrayList<>();
        for (Pessoa pessoa: this.pessoas){
            if (pessoa.getNome().equalsIgnoreCase(nome)){
                pessoasEncontradas.add(pessoa);
            }
        }
        return pessoasEncontradas;
    }

    @Override
    public String toString() {
        return "PessoasList{" +
                "pessoas=" + pessoas +
                '}';
    }
}
