import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

// Найти пропущенное число в массиве
public class FindMissingNumber {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 4, 5};
        int n = array.length + 1;
        findNumber(array, n);
        findNumberWithFormula(array, n);
        findNumberWithStream(array, n);
    }

    // Способ через Set
    public static void findNumber(Integer[] array, int n) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array)); // Arrays.asList() не работает с примитивами Int[] array
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    // Способ через формулу
    public static void findNumberWithFormula(Integer[] array, int n) {
        int expectedSum = n * (n + 1) / 2;  // Сумма всех чисел от 1 до n включительно
        int actualSum = 0; // Сумма элементов массива
        for (int num : array) {
            actualSum += num;
        }
        int missingNumber = expectedSum - actualSum;  // Пропущенное число
        System.out.println(missingNumber);
    }

    // Способ через Stream
    public static void findNumberWithStream(Integer[] array, int n) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        IntStream.range(1, n + 1)
                .filter(i -> !set.contains(i)) // Фильтруем элементы, которых нет в Set
                .findFirst() // Находим первый элемент, который отсутствует
                .ifPresent(System.out::println); // Печатаем пропущенное число
    }
}