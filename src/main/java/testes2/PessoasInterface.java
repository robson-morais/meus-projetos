package testes2;

import java.util.List;

public interface PessoasInterface {
    void cadastrarpessoa(String nome, int idade);
    List<Pessoa> pesquisarPessoasPorNome(String nome);
}
