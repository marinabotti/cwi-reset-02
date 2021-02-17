public class Apartamento extends Imovel {

    private int andar;

    public Apartamento(String logradouro, int numero, String complemento, String bairro, String cidade, UnidadeFederativa estado, double valor, int andar) {
        super(logradouro, numero, complemento, bairro, cidade, estado, valor);
        this.andar = andar;
    }

    public String apresentacao() {
        return " Tipo do imóvel: Apartamento " +
                " \n Andar do apartamento: " + andar + " ° \n " +
                 super.apresentacao();

    }

}



