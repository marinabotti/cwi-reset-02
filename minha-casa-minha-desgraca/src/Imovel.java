public  abstract  class  Imovel {

    private double valor;
    private Endereco endereco;

    public  Imovel (String logradouro ,int numero ,String complemento ,String bairro ,String cidade ,UnidadeFederativa estado ,double valor ){
        endereco = new Endereco(logradouro,numero,complemento,bairro,cidade,estado);
        this.valor = valor;
    }
    public  String  apresentacao () {
        return   " Imóvel localizado no seguinte endereço: \n "  +
                " Logradouro: "  + endereco.getLogradouro() +
                " \n Número: "  + endereco.getNumero() +
                " \n Complemento: "  + endereco.getComplemento() +
                " \n Bairro: "  + endereco.getBairro() +
                " \n Cidade: "  + endereco.getCidade() +
                " \n Estado: "  + endereco.getEstado().getNome() +
                " \n Valor do imóvel: R$ "  +  this.valor +  " \n " ;
    }

    public double getValor(){
        return valor;
    }

    public Endereco getEndereco(){
        return endereco;
    }
}
