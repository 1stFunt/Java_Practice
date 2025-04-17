import java.util.*;

public class LiveCoding {
    public static void main(String[] args) {
        //напиши метод java который развернет массив {1, 2, 3, 4, 5}
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(numbers)));
        //Есть строка “12ф3 321 45в6”. Нужно посчитать сумму чисел этой строки
        String str = "12ф3 321 45в6";
        System.out.println(sum(str));
        System.out.println(sumV2(str));
        // Убрать дубликаты коллекции используя цикл Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6, 7)
        List<Integer> arr = Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6, 7);
        System.out.println(dub(arr));
        // С помощью Stream
        arr.stream().distinct().forEach(System.out::println);
        List<User> users = Arrays.asList(new User("A", 1), new User("B", 2),
                new User("c", 3), new User("A", 3));
        SortedSet<User> sortedUsers = new TreeSet<>(users);
        System.out.println(sortedUsers);
    }

    public static int[] reverse(int[] numbs) {
        int temp = 0;
        for (int i = 0; i < numbs.length / 2; i++) {
            temp = numbs[i];
            numbs[i] = numbs[numbs.length - 1 - i];
            numbs[numbs.length - i - 1] = temp;
        }
        return numbs;
    }

    public static int sum(String str) {
        int sum = 0;
        char[] ch = str.toCharArray();
        for (char x : ch) {
            if (Character.isDigit(x)) {
                sum += Character.getNumericValue(x);
            }
        }
        return sum;
    }

    public static int sumV2(String str) {
        int sum = 0;
        for (char x : str.toCharArray()) {
            if (x >= '0' && x <= '9') {
                sum += x - '0';
            }
        }
        return sum;
    }

    public static List<Integer> dub(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        for (Integer x : arr) {
            if (!result.contains(x)) {
                result.add(x);
            }
        }
        return result;
    }
}