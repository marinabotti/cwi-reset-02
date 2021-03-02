
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nome")

public class NomeController {

    @Autowired
    private HelloWorldController helloWorldController;
    private static String nome = "Marina";

    @GetMapping
    public String getNome() {
        return nome;
    }

    @PutMapping("/{nome}")
    public String putNome(@PathVariable("nome") String novoNome) {
        this.nome = novoNome;
        return this.nome;
    }

    @DeleteMapping
    public void deleteNome(){
        this.nome = null;
    }

}




