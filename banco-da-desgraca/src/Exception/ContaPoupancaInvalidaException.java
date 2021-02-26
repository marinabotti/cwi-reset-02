package Exception;


public class ContaPoupancaInvalidaException extends RuntimeException {
    public ContaPoupancaInvalidaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }

}
