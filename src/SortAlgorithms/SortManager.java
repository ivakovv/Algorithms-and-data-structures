package SortAlgorithms;

import java.util.Stack;

public class SortManager {

    public static int[] bubbleSortDesc(int[] arr){
        int temp = 0;
        int ifCount = 0;
        int swapCount = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                ifCount++;
                if(arr[j] < arr[j + 1]){
                    swapCount++;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(ifCount + " " + swapCount);
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        int ifCount = 0;
        int swapCount = 0;
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                ifCount++;
                if(arr[minIndex] > arr[j]){

                    minIndex = j;}
            }
            if(minIndex != i){
                swapCount++;
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(ifCount);
        System.out.println(swapCount);
        return arr;
    }
    public static int[] insertionSort(int[] arr) {
        int swap = 0;
        int ifCount = 0;

        for (int i = 1; i < arr.length; i++) {
            int sorted = i - 1;
            while (sorted > -1 && arr[sorted] > arr[sorted + 1]) {
                ifCount++;

                int temp = arr[sorted];
                arr[sorted] = arr[sorted + 1];
                arr[sorted + 1] = temp;
                sorted--;

                swap++;
            }

            if (sorted > -1) {
                ifCount++;
            }
        }

        System.out.println("Количество сравнений: " + ifCount);
        System.out.println("Количество перестановок: " + swap);

        return arr;
    }

    public static int[] shakeSort(int[] arr){
        int swapCount = 0;
        int ifCount = 0;
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j < arr.length - i; j++){

                ifCount++;
                if(arr[j] < minValue){
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            for(int k = minIndex; k < arr.length - i - 1; k++){
                swapCount++;
                temp = arr[k + 1];
                arr[k + 1] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println(ifCount + " " + swapCount);
        return arr;
    }
    public static int[] shakeSortModified(int[] arr) {
        int swapCount = 0;
        int ifCount = 0;
        int temp = 0;
        int direction = 1;
        for(int i = 0; i < arr.length; i++){
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;
            int minIndex = 0, maxIndex = 0;
            for(int j = 0; j < arr.length - i; j ++){
                ifCount++;
                if(arr[j] < minValue){
                    minValue = arr[j];
                    minIndex = j;
                }
                if (arr[j] > maxValue){
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }
            for(int k = i; k < arr.length - i - 1; k++){
                swapCount++;
                temp = arr[k + 1];
                arr[k + 1] = arr[k];
                arr[k] = temp;
            }
            for(int k = arr.length - i; k > i; k--){
                System.out.print(i);
                swapCount++;
                temp = arr[k];
                arr[k] = arr[k-1];
                arr[k-1] = temp;
            }

        }
        System.out.println(ifCount + " " + swapCount);
        return arr;
    };




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
