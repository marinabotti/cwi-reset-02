package Exercicio01;

public class Aplicacao {

    public static void main(String[] args) {
        Diretor diretor = new Diretor("Christopher Nolan", 50, 100,Genero.MASCULINO);

        Filme interestelar = new Filme("Interestelar", "Melhor filme", 120, 2014, 5, diretor);
        Filme batman = new Filme("Batman", "Melhor triologia", 90, 2008, 5, diretor);

        interestelar.reproduzir();
        batman.reproduzir();
    }
}
