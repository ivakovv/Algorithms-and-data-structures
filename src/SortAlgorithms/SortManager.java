package SortAlgorithms;

public class SortManager {

    public static int[] BubbleSortDesc(int[] mass){
        int helpPer = 0;
        for(int i = 0; i < mass.length - 1; i++){
            for(int j = 0; j < mass.length - i - 1; j++){
                countIf++;
                if(mass[j] < mass[j + 1]){
                    countSwap++;
                    helpPer = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = helpPer;
                }
            }
        }
        return mass;
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
