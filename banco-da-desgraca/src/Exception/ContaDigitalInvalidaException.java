package Exception;


public class ContaDigitalInvalidaException extends RuntimeException {
    public ContaDigitalInvalidaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }

}