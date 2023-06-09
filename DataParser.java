package dz3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class DataParser {
    public static String[] parseData(String str) {
        // парсим введенные данные
        String[] words = str.split(" ");
        //сождаем массив для компоновки данных
        String[] outArr = new String[6];
        try {
            //                                    1      2       3          4            5      6
            // если размер массива не равен 6 (фамилия, имя, отчество, дата рождения, телефон, пол)
            // выкидываем прерывание
            if (words.length != 6) {
                System.out.println(Arrays.toString(words));
                throw new RuntimeException("Вы ввели меньше или больше запрошенных данных!");
            }
            int idx = 0;
            // проходим по массиву, ищем данные
            for (String word : words) {
                // если в строке только буквы и длинна слова больше чем 2, записываем в выходной массив
                // Фамилия- индекс 0
                // Имя- индекс 1
                // Отчество- индекс 2
                if (isAlpha(word) & word.length() > 2) {
                    outArr[idx] = word;
                    idx++;
                }

                // если длинна слова = 10 и оно проходит проверку, что это корректная дата
                // записываем как день рождения - индекс 3
                if (isValidDate(word) & word.length() == 10) outArr[3] = word;

                // если в строке только цифры, то записываем как телефон - индекс 4
                if (isNumber(word)) outArr[4] = word;

                // если длинна слова равна 1 и это буква, записываем как пол - индекс 5
                if (word.length() == 1 & isAlpha(word)) outArr[5] = word;
            }
            // возвращаем подготовленный массив
            return outArr;
        } catch (RuntimeException re) {
            // при выпадении исключения, выводим сообщение и перезапускаем программу
            System.out.println(re.getMessage());
            Ui.runApp();
        }
        return outArr;
    }

    // метод проверки, что все символы в строке являются буквами
    public static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    // метод проверки, что все символы в строке являются цифрами
    public static boolean isNumber(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // метод проверки, что все строк является корректной датой
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}