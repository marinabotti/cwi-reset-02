package Util;


import java.time.LocalDate;

public class DataUtil {
    private static  LocalDate data = LocalDate.of(2020, 7, 1);

    /**
     * Utilize este método para obter uma data.
     *
     * Como o próprio nome diz, a data deve ser obtida para uso numa transação (na criação de uma transação).
     */
    public static LocalDate getDataTransacao() {
        data = data.plusDays(5);
        return data;
    }

}
