package dz3;

import java.io.FileWriter;
import java.io.IOException;

public class DataInFileWriter {

    // метод для записи данных в файл, при выпадении исключения
    // выводим сообщение и перезапускаем программу
    public static void dataWriter(String data, String fileName) {
        try (FileWriter file = new FileWriter(fileName + ".txt", true)) {
            file.write(data + "\n");
            System.out.println(data);
        } catch (IOException e) {
            System.out.println("Не удалось сохранить данные в файл!");
            System.out.println(e.getMessage());
            Ui.runApp();
        }
    }
}
