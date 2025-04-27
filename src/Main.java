import SortAlgorithms.SortManager;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Рандомные
        //int[] mass = new int[]{45, 12, 78, 34, 56, 89, 23, 67, 90, 10};
        //int[] mass = new int[]{34, 56, 78, 12, 45, 89, 23, 67, 90, 10, 55, 33, 22, 11, 44, 66, 77, 88, 99, 100};
        //int[] mass = new int[]{45, 12, 78, 34, 56, 89, 23, 67, 90, 10, 55, 33, 22, 11, 44, 66, 77, 88, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //В обратном порядке
        //int[] mass = new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        //int[] mass = new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int[] mass = new int[]{30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};


        //Почти отсортированные
        //int[] mass = new int[]{1, 2, 4, 3, 5, 6, 7, 8, 10, 9};
        //int[] mass = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 19};
        //int[] mass = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 30, 29};

        //int[] mass = new int[]{10, 9, 6, 7, 8, 5, 2, 3, 4, 1};
//        int[] mass = new int[]{20, 19, 16, 17, 18, 15, 12, 13, 14, 11,
//                10, 9, 6, 7, 8, 5, 2, 3, 4, 1};
//        int[] mass = new int[]{30, 29, 26, 27, 28, 25, 22, 23, 24, 21,
//                20, 19, 16, 17, 18, 15, 12, 13, 14, 11,
//                10, 9, 6, 7, 8, 5, 2, 3, 4, 1};
        //System.out.println(Arrays.toString(SortAlgorithms.SortManager.insertionSort(mass)));
        int[] mass = new int[]{15, 8, 29, 93, 31, 55, 70};
        int[] mass2 = new int[]{15, 8, 29, 93, 31, 55, 70};
        System.out.println(Arrays.toString(SortManager.bubbleSortDesc(mass)));
        System.out.println(Arrays.toString(SortManager.shakeSortModified(mass2)));

    }
}