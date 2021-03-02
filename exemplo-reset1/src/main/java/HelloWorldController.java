import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public  class  HelloWorldController {

    private  static  String mensagem =  " Hello World " ;

    @GetMapping ( " / hello-world " )
    public  String  helloWorld () {
        return mensagem;
    }

    @PutMapping ( "/hello-world / {novaMensagem} " )
    public  String  mudarMensagem (@PathVariable("nome")  String  novaMensagem ) {
       this.mensagem = novaMensagem;
        return this.mensagem;
    }

}