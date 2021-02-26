package Exception;


public class SaqueInvalidoException extends RuntimeException {
    public SaqueInvalidoException(String mensagemDeErro) {
        super(mensagemDeErro);
    }

}