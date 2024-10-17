package testes2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorPessoas {

    public static final String NOME_ARQUIVO_PESSOAS = "pessoas.txt";


    public void gravadorDeTexto(List<String> texto){

    }




    public void gravarPessoas(List<Pessoa> pessoas) throws IOException {
        List<String> textoDasPessoas = new ArrayList<>();
        for (Pessoa pessoa: pessoas){
            String linhaPessoa = pessoa.getNome()+"###"+pessoa.getIdade();
        }
        //TODO -->> gravadorDeTexto(textoDasPessoas)
    }





}