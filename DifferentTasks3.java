import java.util.*;

public class DifferentTasks3 {
    public static void main(String[] args) {
        System.out.println("Проверка на анаграмму:"); // Проверка анаграмм
        System.out.println(isAnagram("abbc", "abcc")); // false
        System.out.println("\nПроверка на число Армстронга:"); // Проверка на число Армстронга
        int num = 153;
        checkArmstrong(num); // Проверка для числа 153
        System.out.println("\nТаблица умножения:"); // Вывод таблицы умножения
        printMultiplicationTable(); // Вывод таблицы умножения
        System.out.println("\nПроверка на палиндром:"); // Проверка на палиндром
        String str = "A man a plan a canal Panama";
        System.out.println(isPalindrome(str)); // true
        int[] arr = {1, 3, 3, 3, 4, 5, 6, 6, 7, 7, 7, 7, 8, 9, 9, 9}; // Нахождение дубликатов и их количества
        findDuplicates(arr);
        int[] array = {2, 5, 3, 2, 3, 4, 6, 7, 5, 4, 8, -1}; // Метода для нахождения уникальных элементов
        findUniqueElements(array);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6); // Макс и мин число
        findMinAndMax(list);
        minAndMax(list);
    }

    // Метод для проверки, является ли строка анаграммой
    public static boolean isAnagram(String real, String anagram) {
        if (real.length() != anagram.length()) {
            return false; // Если длина строк не совпадает, они не могут быть анаграммами
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : real.toCharArray()) { // Подсчёт символов в первой строке
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : anagram.toCharArray()) { // Вычитание символов второй строки
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return false; // Если символа нет в первой строке или его количество отрицательное, строки не анаграммы
            }
            counts.put(c, counts.get(c) - 1);
        }
        return true; // Если все символы совпадают, строки являются анаграммами
    }

    // Метод для проверки числа на число Армстронга
    public static void checkArmstrong(int num) {
        int original = num;
        int result = 0;
        int countNumber = String.valueOf(num).length(); // Определяем количество цифр
        while (num > 0) {
            int digit = num % 10;
            result += Math.pow(digit, countNumber); // Возводим цифры в степень количества цифр
            num /= 10;
        }
        if (original == result) // Сравниваем результат с оригинальным числом
            System.out.println(original + " является числом Армстронга");
        else
            System.out.println(original + " не является числом Армстронга");
    }

    // Метод для вывода таблицы умножения
    public static void printMultiplicationTable() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println("========================");
        }
    }

    // Метод для проверки, является ли строка палиндромом
    public static boolean isPalindrome(String str) {
        str = str.replaceAll(" ", "").toLowerCase(); // Убираем пробелы и приводим строку к нижнему регистру
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false; // Сравниваем символы с двух сторон
        }
        return true; // Если все символы совпадают, строка палиндром
    }

    // Метод для нахождения дубликатов и их количества
    public static void findDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(); // Хэш-карта для подсчета количества вхождений каждого числа
        for (int i : arr) { // Подсчёт частоты каждого числа в массиве
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // Вывод чисел, которые встречаются больше одного раза
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " шт");
            }
        }
    }

    // Уникальные элементы
    public static void findUniqueElements(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) { // Подсчитываем количество вхождений каждого элемента
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> uniqueElements = new ArrayList<>(); // Ищем элементы, которые встречаются ровно один раз
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueElements.add(entry.getKey());
            }
        }
        if (!uniqueElements.isEmpty()) {
            System.out.println("Уникальные элементы в массиве: " + uniqueElements);
        } else {
            System.out.println("В массиве нет уникальных элементов");
        }
    }

    // Макс и мин число
    public static void findMinAndMax(List<Integer> list) {
        int max = list.get(0);
        int min = list.get(0);
        for (int num : list) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Максимальное число: " + max + ", Минимальное число: " + min);
    }

    // Макс и мин число через Стрим
    static void minAndMax(List<Integer> list) {
        int min = list.stream().min(Integer::compareTo).get();
        int max = list.stream().max(Integer::compareTo).get();
        System.out.println("Максимальное число: " + max + ", Минимальное число: " + min);
    }
}