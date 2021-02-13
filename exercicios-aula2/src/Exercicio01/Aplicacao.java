package Exercicio01;

public class Aplicacao {


    public static void main(String[] args){

        Filme filmeTitanic = new Filme("Titanic", "Suspense",220,1999,"5.0",
                "ABC"," James Cameron",60,"100");

        Filme filmePsicose = new Filme("Psicose", "Terror",60, 1957,"5.0",
                "ABC","XXXX",80,"5");

        filmeTitanic.exibirFilme();
        filmePsicose.exibirFilme();

    }
}
