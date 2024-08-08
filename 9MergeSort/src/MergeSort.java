
import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
//        if (l >= r)
//            return;
        if (r - l <= 15) {
            InsertSort.sort(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        // 对左边递归
        sort(arr, l, mid);
        // 对右边递归
        sort(arr, mid + 1, r);
        // 合并
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    // 合并两个有序区间arr[l,mid]和arr[mid+1,r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        // 每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                // 左侧处理完成
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                // 右侧处理完成
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortHelper.testSort("MergeSort", arr);
    }
}
