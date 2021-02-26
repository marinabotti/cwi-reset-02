package Dominio;

public enum InstituicaoBancaria {

    BANCO_DO_BRASIL("Banco do Brasil"),
    BRADESCO("Bradesco"),
    CAIXA("Caixa"),
    ITAU("Itaú"),
    NUBANK("Nubank");

    private String nome;

    InstituicaoBancaria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
