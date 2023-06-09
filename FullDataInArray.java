package dz3;

public class FullDataInArray {
    // проверяем что данные получены полностью
    public static boolean fullDataInput(String[] array) {
        for (String word : array) {
            if (word == null) return false;
        }
        return true;
    }
}
