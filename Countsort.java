package countsort;
import java.util.Arrays;
import java.util.Scanner;

public class Countsort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(Arrays.toString(count(array,size)));
    }

    static int[] count(int[] array, int size) {
        int max=Arrays.stream(array).max().getAsInt();
        int[] output = new int[size+1];
        int[] count = new int[max+1];
        for (int i = 0; i <= max; ++i)
        {
            count[i] = 0;
        }

        for (int i = 0; i < size; i++)
        {
            count[array[i]]++;
        }

        for(int i = 1; i<=max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        for(int i = 0; i<size; i++) {
            array[i] = output[i];
        }
        return array;
    }
}