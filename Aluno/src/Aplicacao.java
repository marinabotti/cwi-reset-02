public class Aplicacao {

    public static void main(String[] args){

        Aluno novoAluno = new Aluno();

        novoAluno.setNomeAluno("Marina Botti");
        novoAluno.setNotaFinal(9);

        System.out.println(novoAluno.getNomeAluno () + " Parabéns, você está Aprovada!: " + novoAluno.getNotaFinal());



    }
}
