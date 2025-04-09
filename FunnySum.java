// Сложение без учёта переносов
public class FunnySum {
    public static void main(String[] args) {
        String aStr = "999";
        String bStr = "999";
        int a = 999;
        int b = 999;
        withString(aStr, bStr);
        withNumber(a, b);
        hardWithNumber(a, b);
    }

    // Способ с помощью строк
    public static void withString(String aStr, String bStr) {
        int int_3 = (aStr.charAt(0) - '0' + bStr.charAt(0) - '0') % 10;  // Первый разряд
        int int_2 = (aStr.charAt(1) - '0' + bStr.charAt(1) - '0') % 10;  // Второй разряд
        int int_1 = (aStr.charAt(2) - '0' + bStr.charAt(2) - '0') % 10;  // Третий разряд
        System.out.println("" + int_3 + int_2 + int_1);
    }

    // Способ помощью цифр
    public static void withNumber(int a, int b) {
        // Сложение поразрядно с отсеиванием лишних цифр
        int int_3 = (a / 100 + b / 100) % 10; // Первый разряд
        int int_2 = (a / 10 % 10 + b / 10 % 10) % 10; // Второй разряд
        int int_1 = (a % 10 + b % 10) % 10; // Третий разряд
        System.out.println("" + int_3 + int_2 + int_1);
    }

    // Заморочистый способ
    public static void hardWithNumber(int a, int b) {
        int i = 1;  // Начинаем с младшего разряда
        int result = 0;  // Это будет итоговый результат
        while (a > 0 || b > 0) {  // Процесс поразрядного сложения
            int sum = (a % 10) + (b % 10);  // Сложение цифр в одном разряде
            result += (sum % 10) * i;  // Добавляем к результату с учётом разряда, оставляя только последнюю цифру
            a = a / 10;  // Уменьшаем числа для перехода к следующему разряду
            b = b / 10;
            i = i * 10;  // Переходим к следующему разряду (уменьшаем степень десяти)
        }
        System.out.println(result);
    }
}