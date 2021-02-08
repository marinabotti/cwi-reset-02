public class Aplicacao {

    public static void main(String[] args){

        Calculadora calculadora = new Calculadora();

        int resultadoSoma1 = calculadora.soma (10,2);
        int resultadoSoma2 = calculadora.soma (5,4);

        int resultadoSubtrai1 = calculadora.subtrai (10,5);
        int resultadoSubtrai2 = calculadora.subtrai (6,4);

        int resultadoDivide1 = calculadora.divide (100,10);
        int resultadoDivide2 = calculadora.divide (50,2);

        int resultadoMultiplica1 = calculadora.multiplica (8,5);
        int resultadoMultiplica2 = calculadora.multiplica(9,9);

        System.out.println(resultadoSoma1);
        System.out.println(resultadoSoma2);
        System.out.println(resultadoSubtrai1);
        System.out.println(resultadoSubtrai2);
        System.out.println(resultadoDivide1);
        System.out.println(resultadoDivide2);
        System.out.println(resultadoMultiplica1);
        System.out.println(resultadoMultiplica2);
    }
}
