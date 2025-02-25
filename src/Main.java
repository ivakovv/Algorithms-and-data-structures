import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] mass = SortAlgorithms.SortManager.generateSortedAscendArray(20);
        //int[] mass = new int[]{10, 9, 6, 7, 8, 5, 2, 3, 4, 1};
//        int[] mass = new int[]{20, 19, 16, 17, 18, 15, 12, 13, 14, 11,
//                10, 9, 6, 7, 8, 5, 2, 3, 4, 1};
//        int[] mass = new int[]{30, 29, 26, 27, 28, 25, 22, 23, 24, 21,
//                20, 19, 16, 17, 18, 15, 12, 13, 14, 11,
//                10, 9, 6, 7, 8, 5, 2, 3, 4, 1};
        System.out.println(Arrays.toString(SortAlgorithms.SortManager.BubbleSortDesc(mass)));

    }
}