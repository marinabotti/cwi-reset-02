
package Dominio;
public enum TipoTransacao {

    DEPOSITAR(" + "),
    SACAR(" - ");


    private String nome;

    TipoTransacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
