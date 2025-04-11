import java.util.Arrays;

public class Codewars7Kyu {
    public static void main(String[] args) {
        int[] array = {15, 11, 10, 7, 12}; // нужно получить [15,7,12,10,11]
        int square = 9119; // 9119 => 811181
        String pin = "4235";
        System.out.println(Arrays.toString(changeArr(array)));
        System.out.println(toSquare(square));
        System.out.println(toSquareV2(square));
        System.out.println(validatePin(pin));
    }

    // [15,11,10,7,12] => [15,7,12,10,11] Самое большое -> самое маленькое и тд.
    public static int[] changeArr(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                result[i] = arr[right--]; // четные — максимумы
            } else {
                result[i] = arr[left++];  // нечетные — минимумы
            }
        }
        return result;
    }

    // Цифры числа в квадрат 9119 => 811181
    public static int toSquare(int num) {
        String str = String.valueOf(num);
        StringBuilder result = new StringBuilder();  // Для хранения результата
        for (char ch : str.toCharArray()) {
            int digit = ch - '0';  // Получаем цифру через вычитание символа '0'
            int squared = digit * digit;  // Возводим цифру в квадрат
            result.append(squared);  // Добавляем результат в строку
        }
        return Integer.parseInt(result.toString());
    }

    // Цифры числа в квадрат 9119 => 811181, второй способ
    public static int toSquareV2(int num) {
        if (num == 0) {  // Проверяем, если число равно 0
            return 0;
        }
        StringBuilder result = new StringBuilder();  // Для хранения результата
        while (num > 0) {
            int digit = num % 10;  // Извлекаем последнюю цифру
            int squared = digit * digit;  // Возводим цифру в квадрат
            result.insert(0, squared);  // Добавляем результат в начало строки
            num /= 10;  // Убираем последнюю цифру из числа
        }
        return Integer.parseInt(result.toString());  // Преобразуем результат обратно в число
    }

    // Проверка 4 или 6 значных PIN-кодов, только цифры
    public static boolean validatePin(String pin) {
        if (pin.length() == 4 || pin.length() == 6) {
            for (char ch : pin.toCharArray()) {
                if (ch < '0' || ch > '9') {  // Или !Character.isDigit(ch)
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}