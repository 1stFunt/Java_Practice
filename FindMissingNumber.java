import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

// Найти пропущенное число в массиве
public class FindMissingNumber {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 4};
        number(array);
        findNumber(array);
        findNumberWithFormula(array);
        findNumberWithStream(array);
    }

    // Самый простой способ
    public static void number(Integer[] numbs) {
        int n = 1;
        for (Integer numb : numbs) {
            if (n != numb) {
                System.out.println(n);
                break;
            }
            n++;
        }
    }

    // Способ через HashSet (плохой вариант из-за нагрузки при большом массиве)
    public static void findNumber(Integer[] array) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array)); // Arrays.asList() не работает с примитивами Int[] array
        for (int i = 1; i <= array.length + 1; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    // Способ через формулу
    public static void findNumberWithFormula(Integer[] array) {
        int n = array.length + 1;
        int expectedSum = n * (n + 1) / 2;  // Сумма всех чисел от 1 до n включительно
        int actualSum = 0; // Сумма элементов массива
        for (int num : array) {
            actualSum += num;
        }
        int missingNumber = expectedSum - actualSum;  // Пропущенное число
        System.out.println(missingNumber);
    }

    // Способ через Stream
    public static void findNumberWithStream(Integer[] numbs) {
        IntStream.range(0, numbs.length)                    // Идем по индексам массива
                .filter(i -> numbs[i] != i + 1)             // Проверяем, совпадает ли элемент с ожидаемым числом (i + 1)
                .findFirst()                                // Находим первый индекс, где нарушается порядок
                .ifPresent(i -> System.out.println(i + 1)); // Выводим недостающее число (i + 1)
    }
}