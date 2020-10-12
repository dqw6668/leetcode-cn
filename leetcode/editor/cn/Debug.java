package editor.cn;


/**
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,1,4,5,2,9,8};
        solution.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
class Solution {
    public int[] fastSort(int[] arr) {
         fun(arr, 0, arr.length - 1);
         return arr;
    }

    // 返回排好序的数的下标k
    public void fun(int[] arr, int left, int right) {
        if (right <= left) return;
        int p = arr[left];
        int i = left + 1, k = i;
        // {0..i}下标的数都小于p   i+1..right 都大于p
        // arr[i] 的数是大于p的
        while (k < right){
            if (arr[k] < p) {
                swp(arr, k, i);
                i++;
            }
            k++;
        }
        swp(arr, left, i - 1);
        fun(arr, left, i - 2);
        fun(arr, i, right);
        // 循环完毕时 {left, i} 小于 p arr[i] = p
    }

    public void swp(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return arr;

        for (int i = 0; i < len - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swp(arr, j + 1, j);
                }
            }
            if (!flag)
                return arr;
        }
        return arr;
    }
}
