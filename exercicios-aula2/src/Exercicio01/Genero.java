package Exercicio01;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_BINARIO("Não_binário");

    private String descricao;

    Genero(String descricao){
        this.descricao = descricao;

    }
}
