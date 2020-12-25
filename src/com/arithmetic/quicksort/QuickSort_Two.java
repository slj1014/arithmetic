package com.arithmetic.quicksort;

import java.util.Arrays;

//快速排序的递归实现——双边循环法
public class QuickSort_Two {
    //快速排序的递归实现----->双边循环的实现方法
    public static int partition(int[] array, int startIndex, int endIndex) {

        //把当前待排序的数组中的第一个元素作为基准元素，基准元素的获取方法有很多种，比如还可以随机获取，或者三选一等等。
        int pivot = array[startIndex];

        //给当前数组设置两个指针，分别指向当前数组的最左和最右边的元素。
        int left = startIndex;
        int right = endIndex;

        //双边循环的关键代码，借助pivot基准元素，与left和right指向的元素进行大小的比较（array[left]<=pivot, array[right]>pivot）
        //然后通过控制left和right指针的移动，实现分治效果。
        while (left != right) {

            //右侧的数组指针right左移
            while (pivot < array[right] && left < right) {
                right--;
            }

            //左侧的数组指针left右移
            while (pivot >= array[left] && left < right) {
                left++;
            }

            //left和right都不移动后，开始交换这两个位置的数组元素，以达到分治。
            if (left < right) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }

        //数组中所有元素都完成比较后，也就是left=right时，进行基准元素与当前left指针指向的元素进行交换
        //并把left指向的元素移动到数组第一位
        array[startIndex] = array[left];
        array[left] = pivot;


        //返回当前基准元素所在的坐标，供后续递归调用。
        return left;

    }


    //快速排序的递归实现----->实现快速排序
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        //递归的终止条件，表明当前只有一个元素无需比较了，排序完成。
        if (startIndex >= endIndex) {
            return;
        }

        //获取基准元素的坐标，
        int pivotIndex = partition(array, startIndex, endIndex);

        //利用基准元素的坐标，对原有的数组进行拆分--->分治法的体现
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = new int[]{10, 2, 54, 9, 17, 5, 67, 40, 12};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


}
