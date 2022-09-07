import java.util.ArrayList;
import java.util.List;


public class Ouvinte {
    private int id;
    private String nome;
    private int idade;
    private String localidade;

    private int nrJogadas;

    private int nrAcertos;

    public Ouvinte() {
        id = 0;
        nome = "";
        idade = 0;
        localidade = "";
        nrJogadas = 0;
        nrAcertos = 0;
    }

    public Ouvinte(int id, String nome, int idade, String localidade, int nrJogadas, int nrAcertos) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.localidade = localidade;
        this.nrJogadas = nrJogadas;
        this.nrAcertos = nrAcertos;
    }

    public Ouvinte(int id, String nome, int idade, String localidade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.localidade = localidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getNrJogadas() {
        return nrJogadas;
    }

    public void setNrJogadas(int nrJogadas) {
        this.nrJogadas = nrJogadas;
    }

    public int getNrAcertos() {
        return nrAcertos;
    }

    public void setNrAcertos(int nrAcertos) {
        this.nrAcertos = nrAcertos;
    }



    @Override
    public String toString() {
        return "Ouvinte ID = " + id + ", nome = " + nome + ", idade = " + idade + ", localidade = " + localidade + ".";
    }
}