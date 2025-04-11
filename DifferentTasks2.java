import java.util.List;
import java.util.Map;

public class DifferentTasks2 {
    public static void main(String[] args) {
        var num1 = Map.of(
                1, List.of(1, 2, 3, 4, 5),
                2, List.of(1, 2, 3, 4, 5));
        System.out.println(allSum(num1));
        System.out.println(allSumStream(num1));
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
}

