import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
        String[] emailsList = { // Проверка валидности email-ов
                "test@mail.ru", "123-kkdf@gmail.com",
                "123@343.com", "qwerty@.com",
                "123123@yandex.com", "test.test@gmail.com",
                "sdfsdfs@gmail."
        };
        System.out.println("Проверка email-ов:");
        System.out.println(isEmailValid(emailsList));
        String input = "Hello world! This is a test. Hello world!"; // Подсчёт частоты слов
        System.out.println("\nЧастота слов:");
        HashMap<String, Integer> wordCount = countWords(input);
        for (String word : wordCount.keySet()) {
            System.out.println(word + ": " + wordCount.get(word));
        }
        String phone = "+7(912)345-67-89";  // Проверка валидности телефонного номера
        System.out.println("\nПроверка номера телефона:");
        System.out.println(phone + " является валидным: " + isPhoneValid(phone));
        String str = "A man a plan a canal Panama"; // Проверка на палиндром
        System.out.println("\nПроверка на палиндром:");
        System.out.println("\"" + str + "\" является палиндромом: " + isPalindrome(str));
    }

    // Метод для проверки валидности email-ов
    private static HashMap<String, Boolean> isEmailValid(String[] emails) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : emails) {
            // Регулярное выражение для проверки email-а
            boolean validate = s.matches("^[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]{2,}$");
            map.put(s, validate);
        }
        return map;
    }

    // Метод для подсчёта частоты слов в строке
    private static HashMap<String, Integer> countWords(String input) {
        // Убираем знаки препинания и приводим строку к нижнему регистру
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        String[] words = cleanedInput.split("\\s+"); // Разделяем строку на слова
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            // Если слово уже есть в словаре, увеличиваем его количество
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        return wordCountMap;
    }

    // Метод для проверки валидности номера телефона по заданному шаблону
    private static boolean isPhoneValid(String str) {
        String regex = "^\\+7\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean isPalindrome(String text) {
        // Убираем все символы, кроме букв и цифр, и приводим строку к единому регистру
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "");
        return cleaned.equalsIgnoreCase(new StringBuilder(cleaned).reverse().toString());
    }
}