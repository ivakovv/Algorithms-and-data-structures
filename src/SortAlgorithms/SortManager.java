package SortAlgorithms;

public class SortManager {

    public static int[] bubbleSortDesc(int[] arr){
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] < arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            }
            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int sorted = i - 1;
            while(sorted > -1 && arr[sorted] > arr[sorted + 1]){
                int temp = arr[sorted];
                arr[sorted] = arr[sorted + 1];
                arr[sorted + 1] = temp;
                sorted--;
            }
        }
    }

    public static int[] generateRandomArray(int n){
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] =(int) (Math.random()  * 100);
        }
        return result;
    }
    public static int[] generateSortedAscendArray(int n){
        int[] result = new int[n];
        int step = (int)(Math.random()*100);
        for (int i = 0; i < result.length; i++) {
            result[i] = i + step * (i + 1);
        }
        return result;
    }
}
