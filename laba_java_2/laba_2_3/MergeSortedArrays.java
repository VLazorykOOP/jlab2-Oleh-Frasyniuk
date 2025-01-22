import java.util.Random;
import java.util.Objects;

public class MergeSortedArrays {
    public static void main(String[] args) {
    
        int[] array1 = generateRandomArray(10);
        int[] array2 = generateRandomArray(10);

        // Сортування методом бульбашки
        bubbleSort(array1);
        bubbleSort(array2);

        // Злиття двох масивів в один упорядкований
        int[] mergedArray = mergeArrays(array1, array2);

 
        System.out.println("Masive 1:");
        printArray(array1);

        System.out.println("Masive 2:");
        printArray(array2);

        System.out.println("Split Masive:");
        printArray(mergedArray);
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Числа від 0 до 99
        }
        return array;
    }

    // Метод сортування бульбашкою
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Метод для злиття двох відсортованих масивів
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        // Злиття двох масивів
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }

        // Додавання залишків з першого масиву
        while (i < array1.length) {
            mergedArray[k++] = array1[i++];
        }

        // Додавання залишків з другого масиву
        while (j < array2.length) {
            mergedArray[k++] = array2[j++];
        }

        return mergedArray;
    }

    // Метод для виведення масиву на екран
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
