public class PropostaFinanciamento {


    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     * <p>
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     * for equivalente a pelo menos 50% do valor do imóvel.
     * <p>
     * Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     * o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */

    private Beneficiario beneficiario;
    private Imovel imovel;
    private int prazoPagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int prazoPagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.prazoPagamento = prazoPagamento;
    }

    public void validarProposta() {

        double relacaoValorImovelSalario = (imovel.getValor() / (beneficiario.getSalario() * prazoPagamento));

        if (imovel.getEndereco().getEstado() == UnidadeFederativa.SAO_PAULO && relacaoValorImovelSalario <= 0.65) {
            imprimirPropostaAprovada();

        } else if (imovel.getEndereco().getEstado() == UnidadeFederativa.RIO_DE_JANEIRO && relacaoValorImovelSalario <= 0.6) {
            imprimirPropostaAprovada();

        } else if (imovel.getEndereco().getEstado() != UnidadeFederativa.RIO_DE_JANEIRO &&
                imovel.getEndereco().getEstado() != UnidadeFederativa.SAO_PAULO &&
                relacaoValorImovelSalario <= 0.5) {
            imprimirPropostaAprovada();

        } else {
            imprimirPropostaNegada();
        }

    }
        private void imprimirPropostaAprovada(){
            System.out.println("Beneficiário: " + beneficiario.getNome());
            System.out.println("Imóvel escolhido: " + imovel.apresentacao() + " \n ");
            System.out.println("Prazo para pagamento: " + prazoPagamento);
            System.out.println("Parabéns!Sua proposta foi aceita!");

        }

        private void imprimirPropostaNegada(){
            System.out.println("Beneficiário: " + beneficiario.getNome());
            System.out.println("Imóvel escolhido: " + imovel.apresentacao() + " \n ");
            System.out.println("Prazo para pagamento: " + prazoPagamento);
            System.out.println("Não foi dessa vez! Proposta negada! ");
        }

    }











