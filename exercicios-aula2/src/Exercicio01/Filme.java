package Exercicio01;

public class Filme {

    private String nome;
    private String descricao;
    private int duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracao, int anoLancamento, int avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir() {
        System.out.println("Nome Filme: " + this.nome);
        System.out.println("Descrção: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Nome do Exercicio01.Diretor: " + this.diretor.getNome());
        System.out.println("Gênero: " + this.diretor.getGenero());
        System.out.println("Idade: " + this.diretor.getIdade());
    }
}
