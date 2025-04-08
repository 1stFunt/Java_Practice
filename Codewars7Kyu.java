import java.util.Arrays;

public class Codewars7Kyu {
    public static void main(String[] args) {
        int[] array = {15, 11, 10, 7, 12}; // нужно получить [15,7,12,10,11]

        System.out.println(Arrays.toString(changeArr(array)));
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
}

