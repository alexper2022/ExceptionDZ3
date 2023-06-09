package dz3;

public class OutDataBuilder {
    public static String outDataCreate(String[] words) {
        // создаем StringBuilder
        StringBuilder sb = new StringBuilder();
        // добавляем все элементы из массива строк в строку для сохранения
        for (String word : words) {
            sb.append("<");
            sb.append(word);
            sb.append(">");
        }
        // возвращаем подготовленную строку
        return sb.toString();
    }
}