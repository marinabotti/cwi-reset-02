package Exercicio01;

public class Filme {

    private String nome;
    private String descricao;
    private int duracao;
    private int lancamento;
    private String avaliacao;
    private String Diretor;
    private String NomeDiretor;
    private int IdadeDiretor;
    private String QuantidadeFilmes;


    public Filme(String nome, String descricao, int duracao, int lancamento, String avaliacao, String diretor, String nomeDiretor, int idadeDiretor, String quantidadeFilmes) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.lancamento = lancamento;
        this.avaliacao = avaliacao;
        Diretor = diretor;
        NomeDiretor = nomeDiretor;
        IdadeDiretor = idadeDiretor;
        QuantidadeFilmes = quantidadeFilmes;
    }


    public void exibirFilme() {
        System.out.println("Nome do filme:" + this.nome);
        System.out.println("descricao:" + this.descricao);
        System.out.println("duracao:" + this.duracao);
        System.out.println("Nome do diretor:" + this.NomeDiretor);

    }

}

