import java.util.*;

public class DifferentTasks {
    public static void main(String[] args) {
        int[] sortedList = {1, 2, 2, 3, 3, 4, 5, 6, 6};
        String str = "([{}])";
        HashMap<Integer, String> change = new HashMap<>(Map.of(1, "One"));
        System.out.println(sortInt(sortedList));
        System.out.println(validate(str));
        System.out.println(changeVar(change));
    }

    // Удалить дубликаты из сортированного списка int[] sortedList = {1, 2, 2, 3, 3, 4, 5, 6, 6}
    private static Set<Integer> sortInt(int[] nums) {
        Set<Integer> sortNum = new HashSet<>(); // Или LinkedHashSet для сохранения оригинального порядка
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
    private static HashMap<String, Integer> changeVar(HashMap<Integer, String> str) {
        HashMap<String, Integer> strInt = new HashMap<>();
        for (var x : str.entrySet()) {
            strInt.put(x.getValue(), x.getKey());
        }
        return strInt;
    }
}
