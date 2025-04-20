import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoreStream {
    public static class SumOfNumbers { // Найти сумму нечетных чисел
        public static void main(String[] args) {
            int result = Stream.of(1, 2, 3, 4, 5, 11)
                    .filter(x -> x % 2 != 0)
                    .mapToInt(x -> x)  //или .reduce(Integer::sum)
                    .sum();                   //или .orElseThrow(RuntimeException::new);
            System.out.println(result);
        }
    }

    static class Stream1 { // Вывести числа без отрицательных знаков
        public static void main(String[] args) {
            List<Integer> num = List.of(1, 2, -3, -4); // компактное создание списка
            List<Integer> result = num.stream()
                    .map(Math::abs)
                    .collect(Collectors.toUnmodifiableList()); // результат в виде неизменяемого списка
            System.out.println(result);
        }
    }

    static class Stream2 {// Считает количество значений стрима
        public static void main(String[] args) {
            System.out.println(Stream.of(13, 35, 76, 89, 90, 67, 85).count());
        }
    }

    static class Stream3 {// Посчитать сумму ключей и значений, нужно сложить все ключи и все инты во всех списках,
        // а затем сложить сумму // ключей и значений
        public static void main(String[] args) {
            var map = Map.of(
                    1, List.of(1, 2, 3, 4, 5),
                    2, List.of(1, 2, 3, 4, 5)
            );
            var sum = map.entrySet()
                    .stream().mapToInt(x -> x.getKey() + x.getValue()
                            .stream().mapToInt(Integer::intValue)
                            .sum())
                    .sum();
            System.out.println(sum);
        }
    }

    static class Stream4 {// Уникальные элементы из списка
        public static void main(String[] args) {
            List<Integer> list = List.of(1, 2, 2, 2, 4, 5);
            List<Integer> list1 = list.stream().distinct().toList();
            System.out.println(list1);
        }
    }

    static class Stream5 {//вывести только четные числа
        public static void main(String[] args) {
            List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            List<Integer> evenNumbers = num.stream()
                    .filter(e -> e % 2 == 0)
                    .toList();
            System.out.println(evenNumbers);
        }
    }

    static class Stream6 {//вывести отсортированный список в порядке убывания
        public static void main(String[] args) {
            List<Integer> num = Arrays.asList(1, 8, 3, 4, 10, 9, 7);
            List<Integer> evenNumbers = num.stream()
                    .sorted(Comparator.reverseOrder())
                    .toList();
            System.out.println(evenNumbers);
        }
    }

    static class Stream7 {//есть ли в списке хотя бы одно четное число
        public static void main(String[] args) {
            List<Integer> num = Arrays.asList(1, 2, 3, 5, 8, 9, 7);
            boolean evenNumbers = num.stream().anyMatch(e -> e % 2 == 0);
            System.out.println(evenNumbers);
        }
    }

    static class CollectionList1 { // Создать коллекцию целых чисел, написать программу:
        //  Которая четные числа умножает на 100, а от нечетных отнимает 100 и возвращает коллекцию.
        //  Количество принимаемых и возвращаемых элементов коллекций должно совпадать//тернарник это- ?
        public static void main(String[] args) {
            List<Integer> firstlist = List.of(10, 15, 20, 5);
            List<Integer> secondlist = firstlist.stream()
                    .map(x -> x % 2 == 0 ? x * 100 : x - 100)
                    .toList();
            System.out.println(firstlist);
            System.out.println(secondlist);
        }
    }

    static class CollectionList2 { /*Напишите программу, которая из списка строк выбирает только те, которые:
    1.	Длиной больше 3 символов.
	2.	Начинаются с буквы “J”.
    3.	Преобразует все выбранные строки в заглавный регистр.*/
        public static void main(String[] args) {
            List<String> list = new ArrayList<>(List.of("Java", "hello", "Jungle", "world", "JavaScript", "J", "john"));
            System.out.println(changeString(list));
        }
        private static List<String> changeString(List<String> list) {
            return list.stream()
                    .filter(s -> s.length() > 3)
                    .filter(s -> s.startsWith("J"))
                    .map(String::toUpperCase)
                    .toList();
        }
    }
}