package editor.cn.Sort;

/**
 * Created by Five on 2020/10/15 15:13
 */
public class BubbleSort {
    public int[] BubbleSort(int[] arr) {
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

    public void swp(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
