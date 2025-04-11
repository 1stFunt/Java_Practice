import java.util.*;
import java.util.stream.Collectors;

public class DifferentTasks {
    public static void main(String[] args) {
        int[] sortedList = {1, 2, 2, 3, 3, 4, 5, 6, 6};
        String str = "([{}])";
        Map<Integer, String> change = new HashMap<>(Map.of(1, "One"));
        List<String> strDuble = new ArrayList<>(List.of("Привет", "Привет", "Пока", "Пока"));
        int[] numbers = {1, 2, 2, 3, 3, 4, 5, 6, 6};
        int[] minus = {-1, -2, -4};
        List<String> surname = new ArrayList<>(List.of("Аведов", "Антоненко", "Гусев", "Павлов"));
        String s = "11111177777000000"; // Заморочистая
        Integer[] arr = {10, 5, 20, 8, 30, 20};
        System.out.println(sortInt(sortedList));
        System.out.println(validate(str));
        System.out.println(changeVar(change));
        System.out.println(changeVarStream(change));
        System.out.println(sortStr(strDuble));
        printFibonacci(6);
        factorial(5);
        System.out.println(sumOddNumbers(numbers));
        System.out.println(convertToPositive(minus));
        System.out.println(convertToPositiveStream(minus));
        System.out.println(getNamesStartingWithA(surname));
        System.out.println(findLongestSubstring(s));
        System.out.println(secondBigNumber(arr));
    }

    // Удалить дубликаты из сортированного списка int[] sortedList = {1, 2, 2, 3, 3, 4, 5, 6, 6}
    private static Set<Integer> sortInt(int[] nums) {
        Set<Integer> sortNum = new HashSet<>(); // Или LinkedHashSet для 100% сохранения оригинального порядка
        for (int num : nums) {
            sortNum.add(num);
        }
        return sortNum;
    }

    // Проверка валидации "([{}])" - результат true
    private static boolean validate(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Character> mapChar = new HashMap<>();
        mapChar.put(']', '[');
        mapChar.put(')', '(');
        mapChar.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (Character x : chars) {
            if (mapChar.containsValue(x)) {
                stack.push(x);
            } else {
                if (stack.isEmpty() || stack.pop() != mapChar.get(x))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    // Меняем местами HashMap<Integer, String> на HashMap<String, Integer>
    private static HashMap<String, Integer> changeVar(Map<Integer, String> str) {
        HashMap<String, Integer> strInt = new HashMap<>();
        for (var x : str.entrySet()) {  // Или Map.Entry<String, Integer> x : str.entrySet
            strInt.put(x.getValue(), x.getKey());
        }
        return strInt;
    }

    // Меняем местами HashMap<Integer, String> на HashMap<String, Integer> (Stream версия)
    private static HashMap<String, Integer> changeVarStream(Map<Integer, String> str) {
        return str.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getValue,  // Ключи нового Map — это значения из исходного Map
                        Map.Entry::getKey,    // Значения нового Map — это ключи из исходного Map
                        (v1, v2) -> v1,       // Если есть дубликаты, оставляем первое значение (v1)
                        HashMap::new          // Указываем, что хотим использовать HashMap
                ));
    }

    // Удалить дубликаты из ArrayList строк
    private static LinkedHashSet<String> sortStr(List<String> strs) {
        return new LinkedHashSet<>(strs);
    }

    // Первые n чисел Фибоначчи и их сумма
    private static void printFibonacci(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(a);
            sum += a;
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println("\n" + sum);
    }

    // Факториал n
    private static void factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(result);
    }

    // Найти сумму нечётных чисел
    private static int sumOddNumbers(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            if (num % 2 != 0) { // проверка на нечётность
                sum += num;
            }
        }
        return sum;
    }

    // Из отрицательных в положительные
    private static List<Integer> convertToPositive(int[] numbers) {
        List<Integer> positiveNumbers = new ArrayList<>();
        for (int num : numbers) {
            positiveNumbers.add(Math.abs(num)); // используем Math.abs() для получения положительного числа
        }
        return positiveNumbers;
    }

    // Из отрицательных в положительные (Stream версия)
    private static List<Integer> convertToPositiveStream(int[] numbers) {
        return Arrays.stream(numbers)          // Преобразуем массив в Stream
                .map(Math::abs)                // Math.abs() - с помощью ссылки на метод или (num -> Math.abs(num))
                .boxed()                       // Преобразуем int в Integer
                .collect(Collectors.toList()); // Собираем результат в список
    }

    // Метод для фильтрации фамилий, начинающихся на букву "А"
    private static List<String> getNamesStartingWithA(List<String> names) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("А")) {
                result.add(name);
            }
        }
        return result;
    }

    // Найти самую длинную подстроку из одинаковых символов, если несколько, то самую левую
    public static String findLongestSubstring(String s) {
        StringBuilder longest = new StringBuilder();
        StringBuilder current = new StringBuilder().append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current.append(s.charAt(i));
            } else {
                // Если символ отличается, начинаем новую подстроку с текущего символа
                current.setLength(1);  // Сбрасываем длину до 1 - можно на 0 и потом append, но медленнее в теории
                current.setCharAt(0, s.charAt(i));  // Устанавливаем текущий символ как единственный в подстроке
            }
            if (current.length() > longest.length()) {
                longest.setLength(0);  // Очищаем longest перед обновлением
                longest.append(current);  // Копируем current в longest
            }
        }
        return longest.toString();
    }

    //Найти второе по величине число в массиве
    public static int secondBigNumber(Integer[] numbs) {
        Arrays.sort(numbs, Collections.reverseOrder()); // Arrays.sort(numbs); - если массив примитив int[]
        return numbs[1];                                // return numbs[numbs.length - 2];
    }
}