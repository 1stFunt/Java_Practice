import java.util.*;

public class DifferentTasks2 {
    public static void main(String[] args) {
        var num1 = Map.of(
                1, List.of(1, 2, 3, 4, 5),
                2, List.of(1, 2, 3, 4, 5));
        int[] numbers = {1, 3, 4, 5, 6, 6, 7, 7, 7, 1, 2, 3};
        System.out.println(allSum(num1));
        System.out.println(allSumStream(num1));
        System.out.println(sequence(numbers));
        duplicates(numbers);
    }

    // Сложить ключи + значения в списках
    public static int allSum(Map<Integer, List<Integer>> lists) {
        int sumKeys = 0;
        int sumValues = 0;
        for (int key : lists.keySet()) {
            sumKeys += key;
        }
        for (List<Integer> list : lists.values()) {
            for (int value : list) {
                sumValues += value;
            }
        }
        return sumKeys + sumValues;
    }

    // Сложить ключи + значения в списках (Stream)
    public static int allSumStream(Map<Integer, List<Integer>> num1) {
        return num1.entrySet().stream() // Получаем поток записей из карты
                .mapToInt(entry -> entry.getKey() + entry.getValue().stream() // Ключ + получаем поток из списка значений
                        .mapToInt(Integer::intValue) // Преобразуем каждый элемент в int
                        .sum()) // Суммируем все значения
                .sum(); // Суммируем все ключи и значения
    }

    // Содержит ли массив три последовательных числа?
    public static boolean sequence(int[] numbs) {
        for (int i = 1; i < numbs.length - 1; i++) {
            if (numbs[i - 1] == numbs[i] - 1 && numbs[i + 1] == numbs[i] + 1) {
                return true;
            }
        }
        return false;
    }

    // Вывести числа из массива у которых есть дубликаты
    public static void duplicates(int[] numbs) {
        Arrays.sort(numbs);
        Set<Integer> find = new HashSet<>();
        for (int i = 0; i < numbs.length - 1; i++) {
            if (numbs[i] == numbs[i + 1]) {
                find.add(numbs[i]);
            }
        }
        System.out.println(find);
    }
}