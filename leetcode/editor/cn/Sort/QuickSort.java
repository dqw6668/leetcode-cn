package editor.cn.Sort;

/**
 * Created by Five on 2020/10/15 15:11
 */
public class QuickSort {
    public int[] quickSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
        return arr;
    }

    // 返回排好序的数的下标k
    public void partition(int[] arr, int left, int right) {
        if (right <= left) return;
        int p = arr[left];
        int i = left + 1, k = i;
        // {1..i-1}下标的数都小于p   i..right 都大于p
        // arr[i] 的数是大于p的
        while (k <= right) {
            if (arr[k] < p) {
                swp(arr, k, i);
                i++;
            }
            k++;
        }
        swp(arr, left, i - 1);
        // swp之后 {0..i-1}下标的数都小于p   i + 1..right 都大于p
        partition(arr, left, i - 2);
        partition(arr, i, right);
    }

    public void swp(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}